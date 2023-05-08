package io.github.ilyaskerbal.authentication

import androidx.annotation.StringRes

enum class AuthenticationMode(@StringRes val label: Int, @StringRes val title: Int, @StringRes val toggle: Int) {
	LOG_IN(R.string.log_in, R.string.form_title_loin, R.string.toggle_need_account),
	SIGN_UP(R.string.sign_up, R.string.form_title_signup, R.string.toggle_use_account);

	fun opposite(): AuthenticationMode = when(this) {
		LOG_IN -> SIGN_UP
		SIGN_UP -> LOG_IN
	}
}