package io.github.ilyaskerbal.settingsapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import io.github.ilyaskerbal.settingsapp.ui.elements.NotificationItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags
import io.github.ilyaskerbal.settingsapp.ui.elements.items.ThemeItem
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ThemeItemTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun theme_item_title_displayed(){
		val id = R.string.notification_title
		val themeOption = ThemeOption.SYSTEM
		composeTestRule.setContent {
			ThemeItem(title = id, currentOption = themeOption)
		}

		composeTestRule.getElementBasedOnString(id).assertIsDisplayed()
	}

	@Test
	fun theme_item_is_enabled(){
		composeTestRule.setContent {
			ThemeItem(title = R.string.theme_title, currentOption = ThemeOption.SYSTEM)
		}

		composeTestRule.getElementBasedOnTag(Tags.THEME_ITEM).assertIsEnabled()
	}

	@Test
	fun theme_item_onClick_popupmenu_is_displayed() {
		composeTestRule.setContent {
			ThemeItem(title = R.string.theme_title, currentOption = ThemeOption.SYSTEM)
		}
		composeTestRule.getElementBasedOnTag(Tags.THEME_ITEM).performClick()
		composeTestRule.getElementBasedOnTag(Tags.THEME_POPUP_MENU).assertIsDisplayed()
	}

	@Test
	fun theme_item_onThemeChange_invoked() {
		val onThemeChange: (Int) -> Unit = mock()
		val index = 2

		composeTestRule.setContent {
			ThemeItem(
				title = R.string.theme_title,
				currentOption = ThemeOption.SYSTEM,
				onThemeChange = onThemeChange
			)
		}
		composeTestRule.getElementBasedOnTag(Tags.THEME_ITEM).performClick()
		composeTestRule.getElementBasedOnTag(Tags.THEME_OPTION + index).performClick()

		verify(onThemeChange).invoke(index)
	}
}