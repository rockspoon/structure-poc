package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ServingOption represents the serving option. Required only for dine-in
 * type. Values: split,share,passed,none
 */

@Serializable
enum class ServingOptionDto {

	@SerialName("split")
	SPLIT,

	@SerialName("share")
	SHARE,

	@SerialName("none")
	NONE,

	@SerialName("passed")
	PASSED;
}
