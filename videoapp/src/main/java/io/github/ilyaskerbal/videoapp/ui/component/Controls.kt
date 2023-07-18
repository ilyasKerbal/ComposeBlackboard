package io.github.ilyaskerbal.videoapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.videoapp.PlayerStatus
import io.github.ilyaskerbal.videoapp.R

@Composable
fun Controls(
	modifier: Modifier = Modifier,
	playerStatus: PlayerStatus,
	togglePlayingState: () -> Unit
) {
	Box(
		modifier = modifier
			.background(MaterialTheme.colorScheme.surface),
		contentAlignment = Alignment.Center
	) {
		IconButton(
			onClick = togglePlayingState,
			enabled = playerStatus != PlayerStatus.LOADING
		) {
			val icon = if (playerStatus == PlayerStatus.PLAYING) Icons.Default.Pause else Icons.Default.PlayArrow
			val contentDescription = stringResource(
				id = if (playerStatus == PlayerStatus.PLAYING) R.string.cd_pause else R.string.cd_play
			)
			Icon(
				imageVector = icon,
				contentDescription = contentDescription
			)
		}
	}
}

@Preview
@Composable
private fun previewControlsPlaying() {
	Controls(
		playerStatus = PlayerStatus.PLAYING,
		togglePlayingState = {}
	)
}

@Preview
@Composable
private fun previewControlsPause() {
	Controls(
		playerStatus = PlayerStatus.PAUSED,
		togglePlayingState = {}
	)
}

@Preview
@Composable
private fun previewControlsLoading() {
	Controls(
		playerStatus = PlayerStatus.LOADING,
		togglePlayingState = {}
	)
}