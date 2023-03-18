package org.hyperskill.photogallery.components.foundation.ColumnRowBox

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics

@Composable
fun Box(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit,
) {
    androidx.compose.foundation.layout.Box(
        modifier = modifier
            .testTag("Box")
            .semantics {
                semContentAlignment = contentAlignment
                semModifier = modifier
            },
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
        content = content
    )
}



val semModifierKey = SemanticsPropertyKey<Modifier>("Modifier")
var SemanticsPropertyReceiver.semModifier by semModifierKey
