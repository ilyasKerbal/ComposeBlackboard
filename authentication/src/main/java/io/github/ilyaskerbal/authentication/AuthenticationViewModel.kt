package io.github.ilyaskerbal.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel : ViewModel() {

	private val _email: MutableStateFlow<String> = MutableStateFlow("")
	private val _password: MutableStateFlow<String> = MutableStateFlow("")

	private val _validRequirements: Flow<List<PasswordRequirement>> = _password.map { password ->
		buildList<PasswordRequirement> {
			if (password.length > 7) add(PasswordRequirement.EIGHT_CHARACTERS)
			if (password.any { it.isUpperCase() }) add(PasswordRequirement.CAPITAL_LETTER)
			if (password.any { it.isDigit()}) add(PasswordRequirement.ONE_DIGIT)
		}
	}

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

	fun handleEvent(event: AuthenticationEvent) : Unit {
		when(event) {
			is AuthenticationEvent.ToggleAuthenticationMode -> {
				_authenticationMode.update { _authenticationMode.value.opposite() }
			}
			is AuthenticationEvent.EmailChanged -> {
				_email.update { event.email }
			}
			is AuthenticationEvent.PasswordChanged -> {
				_password.update { event.password }
			}
			is AuthenticationEvent.Authenticate -> {
				_isLoading.update { true }
				viewModelScope.launch(Dispatchers.IO) {
					delay(2000L)
					withContext(Dispatchers.Main) {
						_isLoading.update { false }
						_error.update { "Ops! Something went wrong!" }
					}
				}
			}
			is AuthenticationEvent.ErrorDismissed -> {
				_error.update { null }
			}
		}
	}
}