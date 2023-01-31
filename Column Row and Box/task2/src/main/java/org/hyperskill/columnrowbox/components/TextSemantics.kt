package org.hyperskill.columnrowbox.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

val semWithStyleKey = SemanticsPropertyKey<SpanStyle>("WithStyle")
var SemanticsPropertyReceiver.semWithStyle by semWithStyleKey

val semColorKey = SemanticsPropertyKey<Color>("Color")
var SemanticsPropertyReceiver.semColor by semColorKey

val semFontSizeKey = SemanticsPropertyKey<TextUnit>("FontSize")
var SemanticsPropertyReceiver.semFontSize by semFontSizeKey

val semFontStyleKey = SemanticsPropertyKey<FontStyle?>("FontStyle")
var SemanticsPropertyReceiver.semFontStyle by semFontStyleKey

val semFontWeightKey = SemanticsPropertyKey<FontWeight?>("FontWeight")
var SemanticsPropertyReceiver.semFontWeight by semFontWeightKey

val semFontFamilyKey = SemanticsPropertyKey<FontFamily?>("FontFamily")
var SemanticsPropertyReceiver.semFontFamily by semFontFamilyKey

val semLetterSpacingKey = SemanticsPropertyKey<TextUnit>("LetterSpacing")
var SemanticsPropertyReceiver.semLetterSpacing by semLetterSpacingKey

val semTextDecorationKey = SemanticsPropertyKey<TextDecoration?>("TextDecoration")
var SemanticsPropertyReceiver.semTextDecoration by semTextDecorationKey

val semTextAlignKey = SemanticsPropertyKey<TextAlign?>("TextAlign")
var SemanticsPropertyReceiver.semTextAlign by semTextAlignKey

val semLineHeightKey = SemanticsPropertyKey<TextUnit>("LineHeight")
var SemanticsPropertyReceiver.semLineHeight by semLineHeightKey

val semOverflowKey = SemanticsPropertyKey<TextOverflow>("Overflow")
var SemanticsPropertyReceiver.semOverflow by semOverflowKey

val semSoftWrapKey = SemanticsPropertyKey<Boolean>("SoftWrap")
var SemanticsPropertyReceiver.semSoftWrap by semSoftWrapKey

val semMaxLinesKey = SemanticsPropertyKey<Int>("MaxLines")
var SemanticsPropertyReceiver.semMaxLines by semMaxLinesKey

val semOnTextLayoutKey = SemanticsPropertyKey<(TextLayoutResult) -> Unit>("OnTextLayout")
var SemanticsPropertyReceiver.semOnTextLayout by semOnTextLayoutKey

val semStyleKey = SemanticsPropertyKey<TextStyle>("Style")
var SemanticsPropertyReceiver.semStyle by semStyleKey

val semAnnotatedStringKey = SemanticsPropertyKey<AnnotatedString>("AnnotatedString")
var SemanticsPropertyReceiver.semAnnotatedString by semAnnotatedStringKey

val semStringKey = SemanticsPropertyKey<String>("String")
var SemanticsPropertyReceiver.semString by semStringKey

val  semAnnotatedString03Key = SemanticsPropertyKey<List<AnnotatedString.Range<SpanStyle>>>("AnnotatedString03")
var SemanticsPropertyReceiver.semAnnotatedString03 by semAnnotatedString03Key


/**
 *
 *
 * TextField
 *
 *
 *
 */


