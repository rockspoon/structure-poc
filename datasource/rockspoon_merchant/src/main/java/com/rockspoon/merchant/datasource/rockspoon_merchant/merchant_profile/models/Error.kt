package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable

/**
 * An error in a request
 *
 * @param code Error code: * `47510001` - invalidMiddleware * `47510002` -
 *     databaseError * `47510003` - invalidQueryParameter * `47510004` -
 *     invalidRequest * `47510005` - integrationError * `47510006` -
 *     makeError * `47510007` - decodeBody * `47510008` - validateError *
 *     `47510009` - operationError * `47510010` - accessDenied *
 *     `47510011` - requiredParameter * `47510012` - invalidParameter *
 *     `47510013` - listError * `47510014` - errorCounting * `47510015` -
 *     missingMerchant * `47510016` - notFound * `47510017` - createError *
 *     `47510018` - updateError * `47510019` - validationAttemptsExceeded *
 *     `47510020` - insufficientReferralBalance * `47510021` -
 *     deleteError * `47510022` - unsignedForReferral * `47510023` -
 *     devicesNotDelivered
 * @param message
 * @param result
 */
@Serializable
data class Error(
    /**
     * Error code: * `47510001` - invalidMiddleware * `47510002` -
     * databaseError * `47510003` - invalidQueryParameter * `47510004` -
     * invalidRequest * `47510005` - integrationError * `47510006` -
     * makeError * `47510007` - decodeBody * `47510008` - validateError *
     * `47510009` - operationError * `47510010` - accessDenied * `47510011` -
     * requiredParameter * `47510012` - invalidParameter * `47510013` -
     * listError * `47510014` - errorCounting * `47510015` - missingMerchant *
     * `47510016` - notFound * `47510017` - createError * `47510018` -
     * updateError * `47510019` - validationAttemptsExceeded * `47510020` -
     * insufficientReferralBalance * `47510021` - deleteError * `47510022` -
     * unsignedForReferral * `47510023` - devicesNotDelivered
     */
    @Serializable(with = BigDecimalSerializer::class)
    val code: java.math.BigDecimal? = null,
    val message: String? = null,
    val result: Boolean? = null
)

