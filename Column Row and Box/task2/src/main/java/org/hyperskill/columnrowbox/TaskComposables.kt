package org.hyperskill.columnrowbox

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import org.hyperskill.columnrowbox.components.Text


@Composable
fun SaveButton() {
    Button(onClick = {}, modifier = Modifier.testTag("SaveButton")) {
        Text("Save", color = Color.White)
    }
}

@Composable
fun CancelButton() {
    Button(onClick = {}, modifier = Modifier.testTag("CancelButton")) {
        Text("Cancel", color = Color.White)
    }
}