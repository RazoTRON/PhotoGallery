package org.hyperskill.columnrowbox.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.text.input.VisualTransformation

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

val semVisualTransformationKey = SemanticsPropertyKey<VisualTransformation>("VisualTransformation")
var SemanticsPropertyReceiver.semVisualTransformation by semVisualTransformationKey

val semSingleLineKey = SemanticsPropertyKey<Boolean>("SingleLine")
var SemanticsPropertyReceiver.semSingleLine by semSingleLineKey