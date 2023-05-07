package io.github.ilyaskerbal.authentication

sealed class AuthenticationEvent {
	object ToggleAuthenticationMode : AuthenticationEvent()
	data class EmailChanged(val email: String): AuthenticationEvent()
	data class PasswordChanged(val password: String): AuthenticationEvent()
	object Authenticate: AuthenticationEvent()
	object ErrorDismissed: AuthenticationEvent()
}
