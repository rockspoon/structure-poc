package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: conversion,residual,conversionExtra,secondDegree */
@Serializable
enum class BonusType(val value: String) {

    @SerialName("conversion")
    CONVERSION("conversion"),

    @SerialName("residual")
    RESIDUAL("residual"),

    @SerialName("conversionExtra")
    CONVERSION_EXTRA("conversionExtra"),

    @SerialName("secondDegree")
    SECOND_DEGREE("secondDegree");

}

