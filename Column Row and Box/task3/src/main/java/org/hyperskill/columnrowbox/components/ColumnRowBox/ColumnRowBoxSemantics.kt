package org.hyperskill.columnrowbox.components.foundation.ColumnRowBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val semContentAlignmentKey = SemanticsPropertyKey<Alignment>("ContentAlignment")
var SemanticsPropertyReceiver.semContentAlignment by semContentAlignmentKey

val semVerticalArrangementKey = SemanticsPropertyKey<Arrangement.Vertical>("VerticalArrangement")
var SemanticsPropertyReceiver.semVerticalArrangement by semVerticalArrangementKey

val semHorizontalAlignmentKey = SemanticsPropertyKey<Alignment.Horizontal>("HorizontalAlignment")
var SemanticsPropertyReceiver.semHorizontalAlignment by semHorizontalAlignmentKey

val semHorizontalArrangementKey = SemanticsPropertyKey<Arrangement.Horizontal>("HorizontalArrangement")
var SemanticsPropertyReceiver.semHorizontalArrangement by semHorizontalArrangementKey

val semVerticalAlignmentKey = SemanticsPropertyKey<Alignment.Vertical>("VerticalAlignment")
var SemanticsPropertyReceiver.semVerticalAlignment by semVerticalAlignmentKey