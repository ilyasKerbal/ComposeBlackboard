package io.github.ilyaskerbal.videoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class VideoViewModel : ViewModel() {

	private val _playerStatus: MutableStateFlow<PlayerStatus> = MutableStateFlow(PlayerStatus.LOADING)

	val uiState: StateFlow<VideoState> = _playerStatus.map {
		VideoState(
			playerStatus = it
		)
	}.stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(),
		initialValue = VideoState()
	)

	fun handleEvent(videoEvent: VideoEvent): Unit = when(videoEvent) {
		VideoEvent.VideoLoaded -> _playerStatus.update { PlayerStatus.IDLE }
		VideoEvent.VideoError -> _playerStatus.update { PlayerStatus.ERROR }
		VideoEvent.ToggleStatus -> togglePlayerStatus()
	}

	private fun togglePlayerStatus() {
		val newPlayerStatus: PlayerStatus = if (_playerStatus.value != PlayerStatus.PLAYING) PlayerStatus.PLAYING else PlayerStatus.PAUSED
		_playerStatus.update { newPlayerStatus }
	}
}