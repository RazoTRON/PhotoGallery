package org.hyperskill.photogallery.internals

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.text.TextLayoutResult
import kotlin.math.abs

fun SemanticsNodeInteraction.isHorizontallyCenteredTo(
    anotherNode: SemanticsNodeInteraction,
    toleranceMargin: Float = 1f,
    lazyMessage: () -> Any,
): SemanticsNodeInteraction {

    val rootNode = anotherNode.fetchSemanticsNode()
    val rootHorizontalCenter = rootNode.boundsInWindow.center.x

    val isText =
        !this.fetchSemanticsNode().config.getOrNull(SemanticsProperties.Text).isNullOrEmpty()

    if (isText) {
        val config = this.fetchSemanticsNode().config
        val list = mutableListOf<TextLayoutResult>()

        val getTextLayoutResult = config.getOrNull(SemanticsActions.GetTextLayoutResult)
            ?: throw IllegalArgumentException("isHorizontallyCenteredTo expects a Text node")

        getTextLayoutResult.action?.invoke(list) // populates list
        val textLayoutResult = list.getOrNull(0)
            ?: throw AssertionError(lazyMessage)

        val textLeft =
            (0 until textLayoutResult.lineCount).fold(Float.POSITIVE_INFINITY) { acc, cur ->
                val lineStart = textLayoutResult.getLineLeft(cur)
                if (lineStart < acc) lineStart else acc
            } // value relative to node

        val textRight =
            (0 until textLayoutResult.lineCount).fold(Float.NEGATIVE_INFINITY) { acc, cur ->
                val lineEnd = textLayoutResult.getLineRight(cur)
                if (lineEnd > acc) lineEnd else acc
            } // value relative to node

        val textDiff = textRight - textLeft // assuming right is greater or equal than left
        val textHorizontalCenter =
            this.fetchSemanticsNode().boundsInRoot.left + textLeft + (textDiff / 2f)

        assert(abs(textHorizontalCenter - rootHorizontalCenter) < toleranceMargin, lazyMessage)
    } else {
        val nodeHorizontalCenter = this.fetchSemanticsNode().boundsInRoot.center.x
        assert(abs(nodeHorizontalCenter - rootHorizontalCenter) < toleranceMargin, lazyMessage)
    }
    return this
}

fun SemanticsNodeInteraction.isVerticallyCenteredTo(
    anotherNode: SemanticsNodeInteraction,
    toleranceMargin: Float = 1f,
    lazyMessage: () -> Any,
): SemanticsNodeInteraction {

    val rootNode = anotherNode.fetchSemanticsNode()
    val rootVerticalCenter = rootNode.boundsInWindow.center.y

    val isText =
        !this.fetchSemanticsNode().config.getOrNull(SemanticsProperties.Text).isNullOrEmpty()

    if (isText) {
        val config = this.fetchSemanticsNode().config
        val list = mutableListOf<TextLayoutResult>()

        val getTextLayoutResult = config.getOrNull(SemanticsActions.GetTextLayoutResult)
            ?: throw IllegalArgumentException("isVerticallyCenteredTo expects a Text node")

        getTextLayoutResult.action?.invoke(list) // populates list
        val textLayoutResult = list.getOrNull(0)
            ?: throw AssertionError(lazyMessage)

        val textTop =
            (0 until textLayoutResult.lineCount).fold(Float.POSITIVE_INFINITY) { acc, cur ->
                val lineTop = textLayoutResult.getLineTop(cur)
                if (lineTop < acc) lineTop else acc
            } // value relative to node

        val textBottom =
            (0 until textLayoutResult.lineCount).fold(Float.NEGATIVE_INFINITY) { acc, cur ->
                val lineBottom = textLayoutResult.getLineBottom(cur)
                if (lineBottom > acc) lineBottom else acc
            } // value relative to node

        val textDiff = textBottom - textTop // assuming right is greater or equal than left
        val textVerticalCenter =
            this.fetchSemanticsNode().boundsInRoot.top + textTop + (textDiff / 2f)

        assert(abs(textVerticalCenter - rootVerticalCenter) < toleranceMargin, lazyMessage)
    } else {
        val nodeVerticalCenter = this.fetchSemanticsNode().boundsInRoot.center.y
        assert(abs(nodeVerticalCenter - rootVerticalCenter) < toleranceMargin, lazyMessage)
    }
    return this
}

fun SemanticsNodeInteraction.isCenteredTo(
    anotherNode: SemanticsNodeInteraction,
    toleranceMargin: Float = 1f,
    lazyMessage: () -> Any,
): SemanticsNodeInteraction {
    this.isVerticallyCenteredTo(anotherNode, toleranceMargin, lazyMessage)
    this.isHorizontallyCenteredTo(anotherNode, toleranceMargin, lazyMessage)
    return this
}

fun SemanticsNodeInteraction.isOnSameRow(
    listOfNodes: List<SemanticsNodeInteraction>,
    lazyMessage: () -> Any,
): SemanticsNodeInteraction {
    val line = this.fetchSemanticsNode().boundsInWindow.top
    val isOnSameRow =
        listOfNodes.all { node -> node.fetchSemanticsNode().boundsInWindow.top == line }
    assert(isOnSameRow, lazyMessage)
    return this
}

fun SemanticsNodeInteraction.isOnSameColumn(
    listOfNodes: List<SemanticsNodeInteraction>,
    lazyMessage: () -> Any,
): SemanticsNodeInteraction {
    val line = this.fetchSemanticsNode().boundsInWindow.left
    val isOnSameColumn =
        listOfNodes.all { node -> node.fetchSemanticsNode().boundsInWindow.left == line }
    assert(isOnSameColumn, lazyMessage)
    return this
}

fun assertNotOverlapEachOthers(
    listOfNodes: List<SemanticsNodeInteraction>,
    lazyMessage: () -> Any,
) {
    listOfNodes.forEachIndexed { i, node ->
        val leftLine = node.fetchSemanticsNode().boundsInWindow.left + 1
        val rightLine = node.fetchSemanticsNode().boundsInWindow.right - 1
        val topLine = node.fetchSemanticsNode().boundsInWindow.top + 1
        val bottomLine = node.fetchSemanticsNode().boundsInWindow.bottom - 1
        val horizontalRange = leftLine..rightLine
        val verticalRange = topLine..bottomLine

        listOfNodes.subList(
            if (i < listOfNodes.lastIndex) i + 1 else listOfNodes.lastIndex,
            listOfNodes.size
        )
            .all { anotherNode ->
                val anotherNodeLeftLine = anotherNode.fetchSemanticsNode().boundsInWindow.left
                val anotherNodeRightLine = anotherNode.fetchSemanticsNode().boundsInWindow.right
                val anotherNodeTopLine = anotherNode.fetchSemanticsNode().boundsInWindow.top
                val anotherNodeBottomLine = anotherNode.fetchSemanticsNode().boundsInWindow.bottom

                val s1 = !horizontalRange.contains(anotherNodeLeftLine)
                val s2 = !horizontalRange.contains(anotherNodeRightLine)
                val s3 = !verticalRange.contains(anotherNodeTopLine)
                val s4 = !verticalRange.contains(anotherNodeBottomLine)

                assert(s1 && s2 && s3 && s4, lazyMessage)
                true
            }
    }
}