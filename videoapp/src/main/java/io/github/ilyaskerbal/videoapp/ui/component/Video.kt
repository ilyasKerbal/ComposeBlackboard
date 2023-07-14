package io.github.ilyaskerbal.videoapp.ui.component

import android.provider.MediaStore.Video
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyaskerbal.videoapp.VideoViewModel

@Composable
fun Video() {
	val videoViewModel: VideoViewModel = viewModel()

	VideoPlayer(
		videoState = videoViewModel.uiState.collectAsState().value,
		handleEvent = videoViewModel::handleEvent
	)
}