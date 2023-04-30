package io.github.ilyaskerbal.settingsapp

enum class MarketingOption(val index: Int) {
	ACCEPT(0), REJECT(1);
	companion object {
		fun fromIndex(index: Int) : MarketingOption = when(index) {
			0 -> ACCEPT
			1 -> REJECT
			else -> throw IllegalArgumentException("Invalid option Index")
		}
	}
}