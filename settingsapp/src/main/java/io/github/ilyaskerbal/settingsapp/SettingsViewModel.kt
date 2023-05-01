package io.github.ilyaskerbal.settingsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class SettingsViewModel: ViewModel() {

	private val _notificationEnabled: MutableStateFlow<Boolean> = MutableStateFlow(true)
	private val _hintsEnabled: MutableStateFlow<Boolean> = MutableStateFlow(true)
	private val _marketingOption: MutableStateFlow<MarketingOption> = MutableStateFlow(MarketingOption.ACCEPT)
	private val _themeOption: MutableStateFlow<ThemeOption> = MutableStateFlow(ThemeOption.SYSTEM)

	val uiState: StateFlow<SettingsState> = combine(
		_notificationEnabled, _hintsEnabled, _marketingOption, _themeOption
	) { notificationEnabled, hintsEnabled, marketingOption, themeOption ->
		SettingsState(
			notificationEnabled = notificationEnabled,
			showHintsEnabled = hintsEnabled,
			marketingOption = marketingOption,
			themeOption = themeOption
		)
	}.stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(),
		initialValue = SettingsState()
	)

	fun toggleNotification(state: Boolean) = _notificationEnabled.update { state }

	fun toggleHints(sate: Boolean) = _hintsEnabled.update { sate }

	fun changeMarketingOption(index: Int) = _marketingOption.update { MarketingOption.fromIndex(index) }

	fun changeThemeOption(index: Int) = _themeOption.update { ThemeOption.fromIndex(index) }
}