package org.hyperskill.columnrowbox.components.foundation.ColumnRowBox

import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val semContentAlignmentKey = SemanticsPropertyKey<Alignment>("ContentAlignment")
var SemanticsPropertyReceiver.semContentAlignment by semContentAlignmentKey