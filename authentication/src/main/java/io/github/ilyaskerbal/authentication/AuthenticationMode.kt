package io.github.ilyaskerbal.authentication

import androidx.annotation.StringRes

enum class AuthenticationMode(@StringRes label: Int) {
	LOG_IN(R.string.log_in),
	SIGN_UP(R.string.sign_up)
}