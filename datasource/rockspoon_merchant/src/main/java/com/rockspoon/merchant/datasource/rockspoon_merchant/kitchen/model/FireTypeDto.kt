package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FireTypeDto(val value: String) {

	@SerialName("together")
	TOGETHER("together"),

	@SerialName("as_ready")
	AS_READY("as_ready"),

	@SerialName("add_on")
	ADD_ON("add_on"),

	@SerialName("rush")
	RUSH("rush"),

	@SerialName("dont")
	DONT("dont"),

	@SerialName("timed_fire")
	TIMED_FIRE("timed_fire"),

	@SerialName("by_course")
	BY_COURSE("by_course")
}