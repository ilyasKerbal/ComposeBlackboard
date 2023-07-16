package io.github.ilyaskerbal.videoapp.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import io.github.ilyaskerbal.videoapp.VideoViewModel

@Composable
fun Video(
	lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
	val videoViewModel: VideoViewModel = viewModel()

	VideoPlayer(
		modifier = Modifier.fillMaxSize(),
		videoState = videoViewModel.uiState.collectAsState().value,
		handleEvent = videoViewModel::handleEvent,
		lifecycleOwner = lifecycleOwner
	)
}