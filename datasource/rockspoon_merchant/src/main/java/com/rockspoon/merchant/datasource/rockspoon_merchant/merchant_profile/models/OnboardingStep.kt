package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Values: BUSINESSENTITYCREATED, RESTAURANTSTATUS, POSREPLACEMENT,
 * WEBSITE, ADDRESS, BUSINESSTYPE, SERVICEMODEL, PLAN, COMPANYTYPE,
 * COMPANYINFORMATION, OWNERS, TERMSSIGNED, BANKINGINFORMATION,
 * VALIDATIONDONE, DEVICEORDER, SUPPORTSCHEDULED, CONTROLPERSON
 */
@Serializable
enum class OnboardingStep(val value: String) {

    @SerialName("businessEntityCreated")
    BUSINESS_ENTITY_CREATED("businessEntityCreated"),

    @SerialName("restaurantStatus")
    RESTAURANT_STATUS("restaurantStatus"),

    @SerialName("posReplacement")
    POS_REPLACEMENT("posReplacement"),

    @SerialName("website")
    WEBSITE("website"),

    @SerialName("address")
    ADDRESS("address"),

    @SerialName("businessType")
    BUSINESS_TYPE("businessType"),

    @SerialName("serviceModel")
    SERVICE_MODEL("serviceModel"),

    @SerialName("plan")
    PLAN("plan"),

    @SerialName("companyType")
    COMPANY_TYPE("companyType"),

    @SerialName("companyInformation")
    COMPANY_INFORMATION("companyInformation"),

    @SerialName("owners")
    OWNERS("owners"),

    @SerialName("termsSigned")
    TERMS_SIGNED("termsSigned"),

    @SerialName("bankingInformation")
    BANKING_INFORMATION("bankingInformation"),

    @SerialName("validationDone")
    VALIDATION_DONE("validationDone"),

    @SerialName("deviceOrder")
    DEVICE_ORDER("deviceOrder"),

    @SerialName("supportScheduled")
    SUPPORT_SCHEDULED("supportScheduled"),

    @SerialName("controlPerson")
    CONTROL_PERSON("controlPerson");

}

