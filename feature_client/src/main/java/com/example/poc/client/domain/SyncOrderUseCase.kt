package com.example.poc.client.domain

import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRemoteServerDataSource
import com.example.poc.core.data.order.OrderRepository
import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Sync an Order.
 */
// We don't know here which datasource the repository will use to sync the data. I am not sure
// if this is the intended behaviour.
/// If this do not depend on the datasource, this could be at the core module.
class SyncOrderUseCase(
    private val orderRepository: OrderRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<Long, Order>(coroutineDispatcher) {

    override fun execute(parameters: Long): Flow<UseCase.Result<Order>> = flow {

        // Fetch in the server, get the response...
        val order: Order = try {

            orderRepository.syncOrder(parameters)
                ?: throw OrderRepository.OrderRemoteNotFoundException(parameters)

        } catch (e: OrderRemoteServerDataSource.SeverUnavailableException) {

            // Emit a result "retrying in 3 seconds" updating it every second
            var retryTimeInMillis = 3_000L
            val retryTimeIntervalInMillis = 1_000L
            while (retryTimeInMillis > 0) {

                emit(UseCase.Result.Retrying(timeInMillisUntilRetry = retryTimeInMillis))

                delay(retryTimeIntervalInMillis)

                retryTimeInMillis -= retryTimeIntervalInMillis
            }

            // Try again. TODO make the number of attempts customisable with while loop
            orderRepository.syncOrder(parameters)
                ?: throw OrderRepository.OrderRemoteNotFoundException(parameters)

        } catch (e: Exception) {
            // Don't emit here, it's violation of transparency. The FlowUseCase class handles the
            // error
            throw e
        }

        // emit the result
        emit(UseCase.Result.Success(data = order))

        // TODO I think I have to say that the flow is finish somewhere. I should review the docs
    }

    // TODO improve this
    class RetryFailedException : RuntimeException()
}