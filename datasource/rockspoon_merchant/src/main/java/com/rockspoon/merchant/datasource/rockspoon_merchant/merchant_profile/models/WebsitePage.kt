package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param bannerImage link to the image to be used as banner in this page
 * @param display if the page should be dislpayed or not
 * @param name the name of the page, used most for organization of the
 *     rendering of the page
 * @param pageData generic data to be used to fill the page, for more
 *     information please check
 *     https://rockspoon.atlassian.net/wiki/spaces/RO/pages/628195353/Website+Config
 *     (WIP)
 * @param pageHeadline text to be displayed at the top of the page
 * @param pageSubHeadline text to be displayed after the headline
 */
@Serializable
data class WebsitePage(
    /** link to the image to be used as banner in this page */
    val bannerImage: String? = null,
    /** if the page should be dislpayed or not */
    val display: Boolean? = null,
    /**
     * the name of the page, used most for organization of the rendering of the
     * page
     */
    val name: String? = null,
    /**
     * generic data to be used to fill the
     * page, for more information please check
     * https://rockspoon.atlassian.net/wiki/spaces/RO/pages/628195353/Website+Config
     * (WIP)
     */
    val pageData: Map<String, String>? = null,
    /** text to be displayed at the top of the page */
    val pageHeadline: String? = null,
    /** text to be displayed after the headline */
    val pageSubHeadline: String? = null
)

