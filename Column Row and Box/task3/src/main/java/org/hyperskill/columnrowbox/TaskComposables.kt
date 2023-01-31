package org.hyperskill.columnrowbox

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactItem(name: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Surface(color = Color(0xFFCCE5FF), modifier = Modifier.size(50.dp), shape = CircleShape) {
            Box(contentAlignment = Alignment.Center) {
                Text("${name.first()}", fontSize = 25.sp)
            }
        }
        Text(name)
    }
}