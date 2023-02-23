package org.hyperskill.photogallery.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val semTextFieldValueKey = SemanticsPropertyKey<String>("TextFieldValue")
var SemanticsPropertyReceiver.semTextFieldValue by semTextFieldValueKey

val semOnValueChangeStringKey = SemanticsPropertyKey<(String) -> Unit>("OnValueChangeString")
var SemanticsPropertyReceiver.semOnValueChangeString by semOnValueChangeStringKey

val semLeadingIconKey = SemanticsPropertyKey<@Composable (() -> Unit)?>("LeadingIcon")
var SemanticsPropertyReceiver.semLeadingIcon by semLeadingIconKey

val semTextFieldColorsBackgroundKey = SemanticsPropertyKey<Color>("TextFieldColorsBackground")
var SemanticsPropertyReceiver.semTextFieldColorsBackground by semTextFieldColorsBackgroundKey

val semTextFieldColorsTextKey = SemanticsPropertyKey<Color>("TextFieldColorsText")
var SemanticsPropertyReceiver.semTextFieldColorsText by semTextFieldColorsTextKey

val semErrorIndicatorColorKey = SemanticsPropertyKey<Color>("ErrorIndicatorColor")
var SemanticsPropertyReceiver.semErrorIndicatorColor by semErrorIndicatorColorKey

val semDisabledIndicatorColorKey = SemanticsPropertyKey<Color>("DisabledIndicatorColor")
var SemanticsPropertyReceiver.semDisabledIndicatorColor by semDisabledIndicatorColorKey

val semFocusedIndicatorColorKey = SemanticsPropertyKey<Color>("FocusedIndicatorColor")
var SemanticsPropertyReceiver.semFocusedIndicatorColor by semFocusedIndicatorColorKey

val semUnfocusedIndicatorColorKey = SemanticsPropertyKey<Color>("UnfocusedIndicatorColor")
var SemanticsPropertyReceiver.semUnfocusedIndicatorColor by semUnfocusedIndicatorColorKey

val semShapeKey = SemanticsPropertyKey<Shape>("Shape")
var SemanticsPropertyReceiver.semShape by semShapeKey