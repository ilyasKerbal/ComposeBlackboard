package io.github.ilyaskerbal.authentication

data class AuthenticationState(
	val email: String,
	val password: String,
	val validRequirements: List<PasswordRequirement>,
	val authenticationMode: AuthenticationMode,
	val isLoading: Boolean,
	val error: String? = null
)
