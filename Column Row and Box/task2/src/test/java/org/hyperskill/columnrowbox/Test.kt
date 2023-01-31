package org.hyperskill.columnrowbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.hyperskill.columnrowbox.components.*
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semHorizontalAlignmentKey
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semHorizontalArrangementKey
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semVerticalArrangement
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semVerticalArrangementKey
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class CustomTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testSaveScreen() {
        composeTestRule.setContent {
            SaveScreen()
        }

        composeTestRule.onRoot().printToLog("SAVE_SCREEN")
        setUp()

        composeTestRule.onNodeWithTag("SaveButton").onParent().assert(
            SemanticsMatcher.expectValue(semHorizontalArrangementKey, Arrangement.SpaceEvenly))
        composeTestRule.onNodeWithTag("CancelButton").onParent().assert(
            SemanticsMatcher.expectValue(semHorizontalArrangementKey, Arrangement.SpaceEvenly))
        composeTestRule.onNodeWithTag("Row").onChildren().assertAny(hasTestTag("SaveButton"))
        composeTestRule.onNodeWithTag("Row").onChildren().assertAny(hasTestTag("CancelButton"))

        composeTestRule.onNodeWithTag("SaveButton").onParent().onParent().assert(
            SemanticsMatcher.expectValue(semVerticalArrangementKey, Arrangement.spacedBy(
                space = 20.dp
            ))
        )

        composeTestRule.onNodeWithTag("CancelButton").onParent().onParent().assert(
            SemanticsMatcher.expectValue(semHorizontalAlignmentKey, Alignment.CenterHorizontally))

    }


}