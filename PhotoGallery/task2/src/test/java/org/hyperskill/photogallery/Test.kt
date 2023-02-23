package org.hyperskill.photogallery

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.hyperskill.photogallery.internals.assertNotOverlapEachOthers
import org.hyperskill.photogallery.internals.isCenteredTo
import org.hyperskill.photogallery.internals.isOnSameRow
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
            CalculatorScreen()
        }

        composeTestRule.onRoot(true).printToLog("SAVE_SCREEN")
        setUp()

        val acButton = composeTestRule.onNodeWithTag("AC")
        val acText = composeTestRule.onNodeWithText("AC", useUnmergedTree = true)
        val b1 = composeTestRule.onNodeWithTag("1", useUnmergedTree = true)
        val b2 = composeTestRule.onNodeWithTag("2", useUnmergedTree = true)
        val b3 = composeTestRule.onNodeWithTag("3", useUnmergedTree = true)
        val b4 = composeTestRule.onNodeWithTag("4", useUnmergedTree = true)
        val b5 = composeTestRule.onNodeWithTag("5", useUnmergedTree = true)
        val b6 = composeTestRule.onNodeWithTag("6", useUnmergedTree = true)
        val b7 = composeTestRule.onNodeWithTag("7", useUnmergedTree = true)
        val b8 = composeTestRule.onNodeWithTag("8", useUnmergedTree = true)
        val b9 = composeTestRule.onNodeWithTag("9", useUnmergedTree = true)

        acText.isCenteredTo(acButton) {
            "Not centered on the window."
        }

        b7.isOnSameRow(listOf(b8, b9)) {
            "Not on the same row."
        }


        assertNotOverlapEachOthers(listOf(acButton, b7, b8, b9, b2, b1, b4, b6, b5, b3)) {
            "OVERLAP"
        }







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

//        composeTestRule.onNodeWithTag("Box").assert(
//            SemanticsMatcher.assertModifiers(semModifierKey, Modifier.padding(20.dp))
//        )




    }


}