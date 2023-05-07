package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ilyaskerbal.authentication.R

@Composable
fun Requirement(
	modifier: Modifier = Modifier,
	label: String,
	satisfied: Boolean
){
	val tint = if (satisfied) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)

	val description = stringResource(
		id = if (satisfied) R.string.cd_password_requirement_satisfied else R.string.cd_password_requirement_needed
	)
	Row(
		modifier = modifier.padding(6.dp).semantics(
			mergeDescendants = true
		){ text = AnnotatedString(description) },
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			modifier = Modifier.size(12.dp),
			imageVector = Icons.Default.Check,
			contentDescription = null,
			tint = tint
		)
		Spacer(modifier = Modifier.width(8.dp))
		Text(
			text = label,
			fontSize = 12.sp,
			color = tint
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun RequirementPreview() {
	Requirement(
		label = stringResource(id = R.string.password_requirement_eight_characters),
		satisfied = true
	)
}

@Preview(showBackground = true)
@Composable
private fun RequirementPreviewNotSatisfied() {
	Requirement(
		label = stringResource(id = R.string.password_requirement_eight_characters),
		satisfied = false
	)
}