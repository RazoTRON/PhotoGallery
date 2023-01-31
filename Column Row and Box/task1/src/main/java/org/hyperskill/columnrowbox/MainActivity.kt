package org.hyperskill.columnrowbox

import androidx.compose.ui.Alignment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.*

// DO NOT import Column, Row and Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tail()
        }
    }
}

@Composable
fun Tail() {
    //DO NOT change the code above

    TailBackground()
    TailTitle("Column, Row\nand Box")

}

//Solution:
//@Preview
//@Composable
//fun Tail() {
//    Box(contentAlignment = Alignment.BottomEnd) {
//        TailBackground()
//        TailTitle("Column, Row\nand Box")
//    }
//}