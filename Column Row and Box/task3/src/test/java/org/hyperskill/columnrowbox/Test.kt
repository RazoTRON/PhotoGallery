package org.hyperskill.columnrowbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semHorizontalAlignmentKey
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semVerticalArrangementKey
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class SearchFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testRegisterScreen() {
        composeTestRule.setContent {
            ContactList()
        }

        composeTestRule.onRoot(true).printToLog("REGISTER_SCREEN")
        setUp()

        composeTestRule.onNodeWithTag("Box").onChild().assert(
            SemanticsMatcher.expectValue(semVerticalArrangementKey, Arrangement.spacedBy(10.dp))
        )

        listOf("Jorah Mormont", "Davos Seaworth", "Melisandre", "Margaery Tyrell", "Arya Stark").forEach {
            composeTestRule.onNodeWithTag("Box").onChild().onChildren().assertAny(hasText(it))
        }

    }


}