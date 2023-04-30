package io.github.ilyaskerbal.settingsapp.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.SettingsViewModel

@Composable
fun SettingsList(
	modifier: Modifier = Modifier
) {
	val viewModel: SettingsViewModel = viewModel()
	val uiState by viewModel.uiState.collectAsState()

	Column(
		modifier = modifier
			.fillMaxSize()
			.verticalScroll(state = rememberScrollState())
	) {
		NotificationItem(
			title = R.string.notification_title,
			state = uiState.notificationEnabled,
			onToggle = viewModel::toggleNotification
		)
		Divider()
	}
}