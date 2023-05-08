package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.authentication.PasswordRequirement

@Composable
fun Requirements(
    modifier: Modifier = Modifier,
    satisfiedRequirement: List<PasswordRequirement>
){
	Column(
		modifier = modifier
	) {
		PasswordRequirement.values().forEach {
			Requirement(
				modifier = Modifier.fillMaxWidth(),
				label = stringResource(id = it.label),
				satisfied = satisfiedRequirement.contains(it)
			)
		}
	}
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun RequirementsPreview() {
	Requirements(
		satisfiedRequirement = listOf()
	)
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun RequirementsPreview2() {
	Requirements(
		satisfiedRequirement = listOf(PasswordRequirement.CAPITAL_LETTER)
	)
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun RequirementsPreview3() {
	Requirements(
		satisfiedRequirement = listOf(
			PasswordRequirement.CAPITAL_LETTER,
			PasswordRequirement.ONE_DIGIT,
			PasswordRequirement.EIGHT_CHARACTERS
		)
	)
}