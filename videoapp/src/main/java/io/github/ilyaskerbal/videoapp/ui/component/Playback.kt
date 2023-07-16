package io.github.ilyaskerbal.videoapp.ui.component

import android.content.Context
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import io.github.ilyaskerbal.videoapp.PlayerStatus
import io.github.ilyaskerbal.videoapp.PlayerStatus.*

@Composable
fun Playback(
	modifier: Modifier = Modifier,
	state: PlayerStatus = PAUSED,
	exoPlayer: ExoPlayer,
	lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
	context: Context
) {

	val currentPlayerState by rememberUpdatedState(state)

	LaunchedEffect(key1 = exoPlayer) {
		exoPlayer.prepare()
	}
	
	DisposableEffect(
		AndroidView(
			factory = {
				PlayerView(it).apply {
					layoutParams = ViewGroup.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT
					)
					hideController()
					useController = false
					player = exoPlayer
				}
			},
			update = {
				when(state) {
					PLAYING -> it.player?.play()
					PAUSED -> it.player?.pause()
					else -> {}
				}
			}
		)
	) {
		onDispose {
			exoPlayer.release()
		}
	}

	DisposableEffect(lifecycleOwner) {
		val observer = LifecycleEventObserver { _: LifecycleOwner, event: Lifecycle.Event ->
			if (currentPlayerState == PLAYING) {
				if (event == Lifecycle.Event.ON_RESUME) {
					exoPlayer.play()
				} else if (event == Lifecycle.Event.ON_PAUSE) {
					exoPlayer.pause()
				}
			}
		}
		lifecycleOwner.lifecycle.addObserver(observer)

		onDispose {
			lifecycleOwner.lifecycle.removeObserver(observer)
		}
	}

}