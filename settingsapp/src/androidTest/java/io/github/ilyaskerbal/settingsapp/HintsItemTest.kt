package io.github.ilyaskerbal.settingsapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import io.github.ilyaskerbal.settingsapp.ui.elements.NotificationItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags
import io.github.ilyaskerbal.settingsapp.ui.elements.items.HintsItem
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class HintsItemTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun hints_item_title_displayed(){
		val id = R.string.notification_title

		composeTestRule.setContent {
			HintsItem(title = id, onToggle = {}, state = true)
		}

		composeTestRule.getElementBasedOnString(id).assertIsDisplayed()

	}

	@Test
	fun hints_item_is_toggleable() {
		composeTestRule.setContent {
			HintsItem(title = R.string.hints_title, onToggle = {}, state = true)
		}
		composeTestRule.getElementBasedOnTag(Tags.HINTS_TOGGLE).assertIsToggleable()
	}

	@Test
	fun hints_item_state_is_valid(){
		composeTestRule.setContent {
			HintsItem(title = R.string.hints_title, onToggle = {}, state = false)
		}
		composeTestRule.getElementBasedOnTag(Tags.HINTS_TOGGLE).assertIsOff()
	}

	@Test
	fun hints_item_toggle_triggers_method() {
		val onToggle: (Boolean) -> Unit = mock()
		composeTestRule.setContent {
			HintsItem(title = R.string.hints_title, onToggle = onToggle, state = false)
		}
		composeTestRule.getElementBasedOnTag(Tags.HINTS_TOGGLE).performClick()

		verify(onToggle).invoke(true)
	}
}