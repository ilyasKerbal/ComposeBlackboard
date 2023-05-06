package io.github.ilyaskerbal.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class AuthenticationViewModel : ViewModel() {

	private val _email: MutableStateFlow<String> = MutableStateFlow("")
	private val _password: MutableStateFlow<String> = MutableStateFlow("")

	private val _validRequirements: MutableStateFlow<List<PasswordRequirement>> = MutableStateFlow(
		emptyList()
	)

	private val _authenticationMode: MutableStateFlow<AuthenticationMode> = MutableStateFlow(AuthenticationMode.LOG_IN)

	private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)

	private val _error: MutableStateFlow<String?> = MutableStateFlow(null)

	val authenticationState: StateFlow<AuthenticationState> = combine(
		_email, _password, _validRequirements, _authenticationMode, _isLoading, _error
	) { email, password, validRequirements, authenticationMode, isLoading, error ->
		AuthenticationState(
			email = email,
			password = password,
			validRequirements = validRequirements,
			authenticationMode = authenticationMode,
			isLoading = isLoading,
			error = error
		)
	}.stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(),
		initialValue = AuthenticationState()
	)

}