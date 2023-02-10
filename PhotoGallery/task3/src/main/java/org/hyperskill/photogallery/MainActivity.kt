package org.hyperskill.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

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

//    ContactItem(name = )

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

