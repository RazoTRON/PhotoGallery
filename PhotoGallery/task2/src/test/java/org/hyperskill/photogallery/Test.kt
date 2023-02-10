package org.hyperskill.photogallery

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.hyperskill.photogallery.components.foundation.ColumnRowBox.semModifierKey
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

        fun SemanticsMatcher.Companion.assertModifiers(
            key: SemanticsPropertyKey<Modifier>,
            expectedValue: Modifier,
        ): SemanticsMatcher {
            return SemanticsMatcher("${key.name} = '$expectedValue'") {
                val keyValue = it.config.getOrElseNullable(key, defaultValue = { null })
                keyValue?.let { keyElements ->
                    return@SemanticsMatcher keyElements.any { expectedValue.any { expectedElements -> keyElements == expectedElements } }
                }
                return@SemanticsMatcher false
            }
        }

        composeTestRule.onNodeWithTag("Box").assert(
            SemanticsMatcher.assertModifiers(semModifierKey, Modifier.padding(20.dp))
        )

//        composeTestRule.onNodeWithTag("SaveButton").onParent().assert(
//            SemanticsMatcher.expectValue(semHorizontalArrangementKey, Arrangement.SpaceEvenly))
//        composeTestRule.onNodeWithTag("CancelButton").onParent().assert(
//            SemanticsMatcher.expectValue(semHorizontalArrangementKey, Arrangement.SpaceEvenly))
//        composeTestRule.onNodeWithTag("Row").onChildren().assertAny(hasTestTag("SaveButton"))
//        composeTestRule.onNodeWithTag("Row").onChildren().assertAny(hasTestTag("CancelButton"))
//
//        composeTestRule.onNodeWithTag("SaveButton").onParent().onParent().assert(
//            SemanticsMatcher.expectValue(semVerticalArrangementKey, Arrangement.spacedBy(
//                space = 20.dp
//            ))
//        )
//
//        composeTestRule.onNodeWithTag("CancelButton").onParent().onParent().assert(
//            SemanticsMatcher.expectValue(semHorizontalAlignmentKey, Alignment.CenterHorizontally))

    }


}