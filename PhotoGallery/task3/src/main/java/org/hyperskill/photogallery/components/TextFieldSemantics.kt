package org.hyperskill.photogallery.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val semTextFieldValueKey = SemanticsPropertyKey<String>("TextFieldValue")
var SemanticsPropertyReceiver.semTextFieldValue by semTextFieldValueKey

val semOnValueChangeStringKey = SemanticsPropertyKey<(String) -> Unit>("OnValueChangeString")
var SemanticsPropertyReceiver.semOnValueChangeString by semOnValueChangeStringKey

val semLeadingIconKey = SemanticsPropertyKey<@Composable (() -> Unit)?>("LeadingIcon")
var SemanticsPropertyReceiver.semLeadingIcon by semLeadingIconKey

val semTrailingIconKey = SemanticsPropertyKey<@Composable (() -> Unit)?>("TrailingIcon")
var SemanticsPropertyReceiver.semTrailingIcon by semTrailingIconKey

val semTextFieldColorsBackgroundKey = SemanticsPropertyKey<Color>("TextFieldColorsBackground")
var SemanticsPropertyReceiver.semTextFieldColorsBackground by semTextFieldColorsBackgroundKey

val semTextFieldColorsTextKey = SemanticsPropertyKey<Color>("TextFieldColorsText")
var SemanticsPropertyReceiver.semTextFieldColorsText by semTextFieldColorsTextKey