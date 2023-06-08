package com.example.poc.core.domain

import androidx.work.WorkInfo
import com.example.poc.core.common.concurrency.WorkDataKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * A sealed class that can be used to monitor the status of a use case.
 * The possible status are Loading, Success, Error, Retrying. Each status
 * may hold values detailing the result. For example, Loading contains the
 * field progress to indicate how much have been loaded already.
 *
 * The result type should be checked like an enum in the UI layer (specifically
 * in the view model) for each type and subsequently modify the UI state of the
 * view. For example, a Loading result would generate a UI state object that
 * indicates that a ProgressIndicator should be show.
 *
 * The Result class should not be consumed directly by the view. The view should
 * only use its UI state class to update itself.
 *
 * @param <T>
 */
sealed class Result<out T> {

    /**
     * Indicates that the operation is in progress.
     *
     * @param progress indicates how much have being finished from 0 to 100.
     * When the progress is not known, the value is null.
     */
    data class Loading(val progress: Int? = null) : Result<Nothing>()

    /**
     * Indicates that a retry operation is schedule to be made. It differs from Loading
     * as no operation is happening and the application is idle waiting for some interval
     * being retries to be over until try again automatically.
     *
     * @param attemptNumber the current index of attempts being made. Starts with 0.
     * @param attemptTotal the maximum value of attempts that will be made.
     * @param timeInMillisUntilRetry the duration in milliseconds between the end of a
     * retry and the next retry.
     */
    data class Retrying(
        val attemptNumber: Int? = null,
        val attemptTotal: Int? = null,
        val timeInMillisUntilRetry: Long? = null
    ) : Result<Nothing>()

    /**
     * Indicates that the operation finished returning a successful result wrapped.
     *
     * @param data the resulted value
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * Indicates that the operation is finished returning an error occurred.
     *
     * @param throwable Throwable with details of the error.
     */
    data class Error(val throwable: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading[progress=$progress]"
            is Retrying -> "Loading[attemptNumber=$attemptNumber,attemptTotal=$attemptTotal," +
                    "timeInMillisUntilRetry=$timeInMillisUntilRetry]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[throwable=$throwable]"
        }
    }

    companion object {

        /**
         * Returns data or a default value when result is not success.
         */
        fun <T> Result<T>.successOr(fallback: T): T {
            return (this as? Success<T>)?.data ?: fallback
        }

        /**
         * Returns the successful data when successful or null when it's not.
         */
        val <T> Result<T>.data: T?
            get() = (this as? Success)?.data

        /**
         * Converts a Flow<T> into a Flow<Result<T>>. Always emit loading with undetermined
         * progress at start.
         *
         * It does not handle the error. Each case should be evaluate the proper error handling
         * strategy. Not all error should be handled equally. Some errors we should notify
         * the user, some not. Some errors we should log, others not.
         */
        fun <T> Flow<T>.asResult(): Flow<Result<T>> = this
            .map<T, Result<T>> { Success(it) }
            .onStart { emit(Loading()) }
            .catch { emit(Error(it)) }

        /**
         * Converts a WorkInfo flow into a Result Flow with WorkInfo.
         */
        fun Flow<WorkInfo>.asWorkInfoResult(): Flow<Result<WorkInfo>> = this
            .map { workInfo ->
                when (workInfo.state) {
                    WorkInfo.State.RUNNING -> {
                        if (workInfo.runAttemptCount == 0) {
                            workInfo.progress.getInt(WorkDataKeys.PROGRESS, -1).let {
                                if (it == -1) Loading(progress = null)
                                else Loading(progress = it)
                            }
                        } else {
                            Retrying(attemptNumber = workInfo.runAttemptCount)
                        }
                    }
                    WorkInfo.State.BLOCKED -> Error(WorkBlockedException)
                    WorkInfo.State.ENQUEUED -> {
                        if (workInfo.runAttemptCount == 0) {
                            Loading(progress = null)
                        } else {
                            Retrying(attemptNumber = workInfo.runAttemptCount)
                        }
                    }
                    WorkInfo.State.SUCCEEDED -> Success(workInfo)
                    WorkInfo.State.FAILED -> Error(WorkFailedException)
                    WorkInfo.State.CANCELLED -> Error(WorkCancelledException)
                }
            }
            .onStart { Loading() }
            .catch { Error(it) }

        object WorkBlockedException : RuntimeException("The work is blocked by another work.")

        object WorkFailedException : RuntimeException("The work has failed.")

        object WorkCancelledException :
            RuntimeException("The work has been cancelled and will not execute.")
    }
}

