package io.github.ilyaskerbal.settingsapp

import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsScreen
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SettingsScreenTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Before
	fun setup() {
		composeTestRule.setContent {
			SettingsScreen()
		}
	}

	@Test
	fun top_appbar_is_displayed() {
		composeTestRule.getElementBasedOnTag(Tags.TOP_APP_BAR).assertIsDisplayed()
	}

	@Test
	fun enable_notifications_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.notification_title)
			.assertIsDisplayed()
	}

	@Test
	fun show_hints_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.hints_title)
			.assertIsDisplayed()
	}

	@Test
	fun manage_subscription_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.subscription_title)
			.assertIsDisplayed()
	}

	@Test
	fun marketing_option_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.marketing_title)
			.assertIsDisplayed()
	}

	@Test
	fun theme_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.theme_title)
			.assertIsDisplayed()
	}

	@Test
	fun version_item_is_displayed(){
		composeTestRule
			.getElementBasedOnString(R.string.version_title)
			.assertIsDisplayed()
	}

	@Test
	fun notification_item_is_toggleable() {
		composeTestRule.getElementBasedOnString(R.string.notification_title).performClick()

		composeTestRule.getElementBasedOnTag(Tags.NOTIFICATION_TOGGLE).assertIsOff()
	}

	@Test
	fun hints_item_is_toggleable() {
		composeTestRule.getElementBasedOnString(R.string.hints_title).performClick()

		composeTestRule.getElementBasedOnTag(Tags.HINTS_TOGGLE).assertIsOff()
	}

	@Test
	fun marketing_option_selectable() {
		val options = InstrumentationRegistry
			.getInstrumentation()
			.targetContext.resources
			.getStringArray(R.array.marketing_options)

		composeTestRule.getElementBasedOnRawString(options[1]).performClick()

		composeTestRule.getElementBasedOnTag(Tags.MARKETING_OPTION + 1).assertIsSelected()
	}

	@Test
	fun theme_popup_menu_is_displayed_when_item_is_clicked() {
		composeTestRule.getElementBasedOnString(R.string.theme_title).performClick()
		composeTestRule.getElementBasedOnTag(Tags.THEME_POPUP_MENU).assertIsDisplayed()
	}
}