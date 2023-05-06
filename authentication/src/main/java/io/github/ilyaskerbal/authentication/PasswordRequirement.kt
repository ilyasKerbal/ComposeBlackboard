package io.github.ilyaskerbal.authentication

import androidx.annotation.StringRes

enum class PasswordRequirement(@StringRes label: Int) {
	CAPITAL_LETTER(R.string.password_requirement_capital_letter),
	ONE_DIGIT(R.string.password_requirement_one_digit),
	EIGHT_CHARACTERS(R.string.password_requirement_eight_characters)
}