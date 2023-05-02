package io.github.ilyaskerbal.settingsapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import io.github.ilyaskerbal.settingsapp.ui.elements.NotificationItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class NotificationItemTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun notification_item_title_displayed(){
		val id = R.string.notification_title
		val title = InstrumentationRegistry.getInstrumentation().targetContext.getString(id)

		composeTestRule.setContent {
			NotificationItem(
				title = id,
				state = true
			)
		}

		composeTestRule.getElementBasedOnString(id).assertIsDisplayed()

	}

	@Test
	fun notification_item_is_toggleable() {
		composeTestRule.setContent {
			NotificationItem(
				title = R.string.notification_title,
				state = true
			)
		}
		composeTestRule.getElementBasedOnTag(Tags.NOTIFICATION_TOGGLE).assertIsToggleable()
	}

	@Test
	fun notification_item_state_is_valid(){
		composeTestRule.setContent {
			NotificationItem(
				title = R.string.notification_title,
				state = false
			)
		}
		composeTestRule.getElementBasedOnTag(Tags.NOTIFICATION_TOGGLE).assertIsOff()
	}

	@Test
	fun notification_item_toggle_triggers_method() {
		val onToggle: (Boolean) -> Unit = mock()
		composeTestRule.setContent {
			NotificationItem(
				title = R.string.notification_title,
				state = false,
				onToggle = onToggle
			)
		}
		composeTestRule.getElementBasedOnTag(Tags.NOTIFICATION_TOGGLE).performClick()

		verify(onToggle).invoke(true)
	}
}