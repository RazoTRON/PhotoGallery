package org.hyperskill.photogallery.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.hyperskill.photogallery.R


val Urabist = FontFamily(
    Font(R.font.urbanist, weight = FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Urabist,
    body1 = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp),
    h4 = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp),
    h6 = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 60.sp),
    button = TextStyle(
        fontFamily = Urabist,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)