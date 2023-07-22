package io.github.ilyaskerbal.videoapp.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import io.github.ilyaskerbal.videoapp.PlayerStatus
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

	Box(
		modifier = modifier.background(Color.Black)
	) {
		var controlsVisible by remember {
			mutableStateOf(true)
		}

		val controlsClickLabel = if (controlsVisible) {
			R.string.label_hide_controls
		} else {
			R.string.label_display_controls
		}
		
		val alphaAnimation by animateFloatAsState(
			targetValue = if (controlsVisible) 0.7f else 0f,
			animationSpec = if (controlsVisible) {
				tween(delayMillis = 0)
			} else tween(delayMillis = 750)
		)


		Playback(
			modifier = Modifier
				.fillMaxSize()
				.clickable(
					onClickLabel = stringResource(id = controlsClickLabel),
					onClick = {
						controlsVisible != controlsVisible
					}
				)
				.testTag(Tags.TAG_VIDEO_PLAYER),
			exoPlayer = exoPlayer,
			context = context,
			state = videoState.playerStatus,
			lifecycleOwner = lifecycleOwner
		)
		Controls(
			modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.BottomCenter)
				.alpha(alphaAnimation),
			playerStatus = videoState.playerStatus,
			togglePlayingState = {
				handleEvent(VideoEvent.ToggleStatus)
				if (videoState.playerStatus != PlayerStatus.PLAYING) {
					controlsVisible = false
				}
			}
		)
	}

}