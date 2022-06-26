package com.example.poc.core.data.preferences

/**
 * Represents the available UI themes in the application preferences.
 */
enum class Theme {

	/**
	 * Light theme.
	 */
	LIGHT,

	/**
	 * Dark theme.
	 */
	DARK,

	/**
	 * When theme is set as System, the theme applied is the one chosen by the user
	 * in the system settings.
	 */
	SYSTEM,

	/**
	 * A theme for saving battery, usually using darker tones.
	 */
	BATTERY_SAVER
}

