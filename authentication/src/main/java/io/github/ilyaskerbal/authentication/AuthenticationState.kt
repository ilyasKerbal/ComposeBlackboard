package io.github.ilyaskerbal.authentication

data class AuthenticationState(
	val email: String = "",
	val password: String = "",
	val validRequirements: List<PasswordRequirement> = emptyList(),
	val authenticationMode: AuthenticationMode = AuthenticationMode.LOG_IN,
	val isLoading: Boolean = false,
	val error: String? = null
){
	fun isAuthenticationEnabled(): Boolean {
		return email.isNotBlank() && when(authenticationMode) {
			AuthenticationMode.LOG_IN -> password.length >= 8
			AuthenticationMode.SIGN_UP -> validRequirements.containsAll(PasswordRequirement.values().toList())
		}
	}
}
