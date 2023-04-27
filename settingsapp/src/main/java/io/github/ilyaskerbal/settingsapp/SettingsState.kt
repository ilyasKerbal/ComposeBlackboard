package io.github.ilyaskerbal.settingsapp

data class SettingsState(
	val notificationEnabled: Boolean = false,
	val showHintsEnabled: Boolean = true,
	val marketingOption: MarketingOptions = MarketingOptions.ACCEPT,
	val themeOptions: ThemeOptions = ThemeOptions.SYSTEM
)