package org.hyperskill.columnrowbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.*
import org.hyperskill.columnrowbox.components.*

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveScreen()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SaveScreen() {
    Box(contentAlignment = Alignment.Center) {
        //DO NOT change the code above

        Text("Do you want to save?")
        SaveButton()
        CancelButton()

    }
}

//Solution:
//@Preview(showSystemUi = true)
//@Composable
//fun SaveScreen() {
//    Box(contentAlignment = Alignment.Center) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Do you want to save?")
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                SaveButton()
//                CancelButton()
//            }
//        }
//    }
//}