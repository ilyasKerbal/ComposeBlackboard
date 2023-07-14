package io.github.ilyaskerbal.videoapp

sealed class VideoEvent {
	object ToggleStatus: VideoEvent()
	object VideoLoaded: VideoEvent()
	object VideoError: VideoEvent()
}
