package org.hyperskill.photogallery

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import org.hyperskill.photogallery.app.fullImage.FullImageScreen
import org.hyperskill.photogallery.components.foundation.ColumnRowBox.semContentAlignment
import org.hyperskill.photogallery.components.foundation.ColumnRowBox.semContentAlignmentKey
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.annotation.RealObject
import org.robolectric.shadow.api.Shadow
import org.robolectric.shadows.ShadowLog
import org.robolectric.util.ReflectionHelpers
import java.lang.Math.abs
import java.lang.invoke.MethodHandles
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.starProjectedType




@RunWith(RobolectricTestRunner::class)
class PasswordFieldTest {



    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testTail() {


        composeTestRule.setContent {
//            Surface(modifier = Modifier.clip(shape = CircleShape), color = Color.Black) { }
            FullImageScreen("", rememberNavController())
            Text("12345", overflow = TextOverflow.Ellipsis, modifier = Modifier.requiredSize(2.dp))
        }



        composeTestRule.onRoot().printToLog("BOX")
        setUp()


        composeTestRule.onNodeWithText("12345").assertTextEquals()


//        composeTestRule.onNodeWithTag("TailTitle").onSiblings().assertAny(hasTestTag("TailBackground"))
//        composeTestRule.onNodeWithTag("TailTitle").onParent().assert(SemanticsMatcher.expectValue(
//            semContentAlignmentKey, Alignment.BottomEnd)
//        )

    }


}


fun isOnSameRowAs(otherNode: SemanticsNodeInteraction): SemanticsMatcher {
    return SemanticsMatcher(
        "is on same row as ${otherNode.printToString(0)}"
    ) { node ->
        val otherNodeYPosition = otherNode.fetchSemanticsNode().positionInWindow.y
        val nodeYPosition = node.positionInWindow.y
        abs(otherNodeYPosition - nodeYPosition) < 10f
    }
}

fun SemanticsNodeInteraction.assertColor(expectedColor: Color, errorMessage: String) {
    val semanticsNode = fetchSemanticsNode()
    val layoutInfo = semanticsNode.layoutInfo
    val modifierInfoList = layoutInfo.getModifierInfo()
    val backgroundModifierInfo =
        modifierInfoList
            .firstOrNull { it.modifier::class.qualifiedName == "androidx.compose.foundation.Background" }
            ?: throw AssertionError("Modifier not found")
    val backgroundModifier = backgroundModifierInfo.modifier
    println(modifierInfoList)
    println(backgroundModifierInfo)
    println(backgroundModifier)

    val colorField = backgroundModifier::class.java.getDeclaredField("color")
    colorField.isAccessible = true
    val actualColor = colorField.get(backgroundModifier) as? Color ?: throw AssertionError("Color not Found")
    assertEquals(errorMessage, expectedColor, actualColor)
}