package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * the data used to generate a website
 *
 * @param links links to other social media related to the restaurant
 * @param logo the venue logo
 * @param pages
 * @param primaryColor the main color of the site in hexadecimal
 * @param secondaryColor the secondary color of the site in hexadecimal
 * @param status the status of the website
 * @param contactEmail the contactEmail of the website
 * @param template the template used display the information of the site
 */
@Serializable
data class WebsiteConfig(
    /** links to other social media related to the restaurant */
    val links: WebsiteLinks? = null,
    /** the venue logo */
    val logo: String? = null,
    val pages: List<WebsitePage>? = null,
    /** the main color of the site in hexadecimal */
    val primaryColor: String? = null,
    /** the secondary color of the site in hexadecimal */
    @SerialName("SecondaryColor")
    val secondaryColor: String? = null,
    /** the status of the website */
    val status: Status? = null,
    /** the contactEmail of the website */
    val contactEmail: String? = null,
    /** the template used display the information of the site */
    val template: Template? = null
) {

    /** the status of the website Values: published,unpublished */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("published")
        PUBLISHED("published"),

        @SerialName("unpublished")
        UNPUBLISHED("unpublished");

    }

    /**
     * the template used display the information of the site Values:
     * classic,directory,marketing
     */
    @Serializable
    enum class Template(val value: String) {

        @SerialName("classic")
        CLASSIC("classic"),

        @SerialName("directory")
        DIRECTORY("directory"),

        @SerialName("marketing")
        MARKETING("marketing");

    }

}

