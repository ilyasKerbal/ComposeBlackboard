package io.github.ilyaskerbal.settingsapp

import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry

fun ComposeContentTestRule.getElementBasedOnString(@StringRes stringId: Int) : SemanticsNodeInteraction = this.getElementBasedOnRawString(
	InstrumentationRegistry.getInstrumentation().targetContext.getString(stringId)
)

fun ComposeContentTestRule.getElementBasedOnTag(tag: String, useUnmergedTree: Boolean = false): SemanticsNodeInteraction = this.onNodeWithTag(tag, useUnmergedTree)

fun ComposeContentTestRule.getElementBasedOnRawString(text: String): SemanticsNodeInteraction = this.onNodeWithText(text)