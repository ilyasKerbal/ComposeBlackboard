package io.github.ilyaskerbal.authentication

data class AuthenticationState(
	val email: String = "",
	val password: String = "",
	val validRequirements: List<PasswordRequirement> = emptyList(),
	val authenticationMode: AuthenticationMode = AuthenticationMode.LOG_IN,
	val isLoading: Boolean = false,
	val error: String? = null
)
