package io.github.ilyaskerbal.settingsapp

data class SettingsState(
	val notificationEnabled: Boolean = false,
	val showHintsEnabled: Boolean = true,
	val marketingOption: MarketingOption = MarketingOption.ACCEPT,
	val themeOption: ThemeOption = ThemeOption.SYSTEM
)