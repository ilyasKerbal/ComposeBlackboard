package io.github.ilyaskerbal.videoapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import io.github.ilyaskerbal.videoapp.R
import io.github.ilyaskerbal.videoapp.Tags
import io.github.ilyaskerbal.videoapp.VideoEvent
import io.github.ilyaskerbal.videoapp.VideoState

@Composable
fun VideoPlayer(
	modifier: Modifier = Modifier,
	videoState: VideoState,
	lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
	handleEvent: (event: VideoEvent) -> Unit
) {
	val context = LocalContext.current
	val exoPlayer: SimpleExoPlayer = remember {
		val media: MediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
		SimpleExoPlayer.Builder(context).build().apply {
			setMediaItem(media)
			addListener(object : Player.Listener {
				override fun onPlaybackStateChanged(playbackState: Int) {
					super.onPlaybackStateChanged(playbackState)
					if (playbackState == Player.STATE_READY) handleEvent(VideoEvent.VideoLoaded)
				}
			})
		}
	}

	Playback(
		modifier = modifier.fillMaxSize()
			.clickable(
				onClickLabel = stringResource(id = R.string.play_video),
				onClick = {
					//TODO: Toggle controls
				}
			).testTag(Tags.TAG_VIDEO_PLAYER),
		exoPlayer = exoPlayer,
		context = context,
		state = videoState.playerStatus,
		lifecycleOwner = lifecycleOwner
	)
}