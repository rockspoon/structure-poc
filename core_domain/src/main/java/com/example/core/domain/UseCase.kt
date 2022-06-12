package com.rockspoon.core.usecase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poc.core.data.user.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /**
     * Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            // Moving all use case's executions to the injected dispatcher
            // In production code, this is usually the Default dispatcher (background thread)
            // In tests, this becomes a TestCoroutineDispatcher
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, e.message ?: "")
            Result.Error(e)
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R

    sealed class Result<out R> {

        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
        data class Loading(val progress: Int? = null) : Result<Nothing>()

        companion object {
            /**
             * `true` if [Result] is of type [Success] & holds non-null [Success.data].
             */
            val Result<*>.succeeded
                get() = this is Success && data != null

            fun <T> Result<T>.successOr(fallback: T): T {
                return (this as? Success<T>)?.data ?: fallback
            }

            val <T> Result<T>.data: T?
                get() = (this as? Success)?.data

            /**
             * Updates value of [liveData] if [Result] is of type [Success]
             */
            inline fun <reified T> Result<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
                if (this is Success) {
                    liveData.value = data
                }
            }

            /**
             * Updates value of [MutableStateFlow] if [Result] is of type [Success]
             */
            inline fun <reified T> Result<T>.updateOnSuccess(stateFlow: MutableStateFlow<T>) {
                if (this is Success) {
                    stateFlow.value = data
                }
            }
        }
    }

    companion object {
        private const val TAG = "UseCase"
    }
}

