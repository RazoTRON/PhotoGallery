package org.hyperskill.columnrowbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hyperskill.columnrowbox.components.Text
import org.hyperskill.textfield.R

@Composable
fun TailBackground() {
    Image(
        painterResource(R.drawable.tail_bg),
        contentDescription = null,
        modifier = Modifier.size(200.dp).testTag("TailBackground")
    )
}

@Composable
fun TailTitle(text: String) {
    Text(
        text = text,
        color = Color.DarkGray,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier
//            .width(200.dp)
            .padding(10.dp)
            .testTag("TailTitle"),
        textAlign = TextAlign.End
    )
}