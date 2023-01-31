package org.hyperskill.columnrowbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hyperskill.columnrowbox.components.Text
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.*

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactList()
        }
    }
}

val contactList = listOf("Jorah Mormont", "Davos Seaworth", "Melisandre", "Margaery Tyrell", "Arya Stark")

@Preview
@Composable
fun ContactList() {
    // DO NOT change the code above

    ContactItem(name = )

}

//@Preview(showSystemUi = true, device = Devices.PIXEL)
//@Composable
//fun ContactList() {
//    Box(contentAlignment = Alignment.CenterStart) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(10.dp),
//        ) {
//            list.forEach {
//                ContactItem(it)
//            }
//        }
//    }
//}

