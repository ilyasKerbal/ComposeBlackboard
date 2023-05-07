package io.github.ilyaskerbal.authentication

import androidx.annotation.StringRes

enum class AuthenticationMode(@StringRes val label: Int, @StringRes val title: Int) {
	LOG_IN(R.string.log_in, R.string.form_title_loin),
	SIGN_UP(R.string.sign_up, R.string.form_title_signup);

	fun opposite(): AuthenticationMode = when(this) {
		LOG_IN -> SIGN_UP
		SIGN_UP -> LOG_IN
	}
}