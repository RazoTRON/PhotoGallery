package org.hyperskill.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hyperskill.photogallery.components.Text
import org.hyperskill.photogallery.ui.theme.HyperskillTheme

// DO NOT import androidx.compose.material.TextField or OutlinedTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HyperskillTheme {
                CalculatorScreen()
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun CalculatorScreen() {
    Column {
        ResultPanel(Modifier.weight(0.9f))
        ButtonsPanel(
            Modifier
                .weight(1.2f)
                .padding(horizontal = 15.dp)
        )
    }
}

@Composable
fun ResultPanel(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text("195", fontSize = 60.sp, style = MaterialTheme.typography.h6)
            Text("125 + 80 - 10", fontSize = 20.sp, style = MaterialTheme.typography.h1)
        }
    }
}

@Composable
fun ButtonsPanel(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CalculatorButton(
                "AC",
                Modifier
                    .weight(1f)
                    .testTag("AC")
            )
            CalculatorButton("+ / -", Modifier.weight(1f).testTag("+ / -"))
            CalculatorButton("%", Modifier.weight(1f).testTag("%"))
            ActionButton("/", Modifier.weight(1f).testTag("/"))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CalculatorButton("7", Modifier.weight(1f).testTag("7"))
            CalculatorButton("8", Modifier.weight(1f).testTag("8"))
            CalculatorButton("9", Modifier.weight(1f).testTag("9"))
            ActionButton("x", Modifier.weight(1f))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CalculatorButton("4", Modifier.weight(1f).testTag("4"))
            CalculatorButton("5", Modifier.weight(1f).testTag("5"))
            CalculatorButton("6", Modifier.weight(1f).testTag("6"))
            ActionButton("-", Modifier.weight(1f).testTag("-"))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CalculatorButton("1", Modifier.weight(1f).testTag("1"))
            CalculatorButton("2", Modifier.weight(1f).testTag("2"))
            CalculatorButton("3", Modifier.weight(1f).testTag("3"))
            ActionButton("+", Modifier.weight(1f).testTag("+"))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CalculatorButton("0", Modifier.weight(1f).testTag("0"))
            CalculatorButton(".", Modifier.weight(1f).testTag("."))
            CalculatorButton("", Modifier.weight(1f))
            ActionButton("=", Modifier.weight(1f).testTag("="))
        }

    }
}

@Composable
fun CalculatorButton(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
//                .aspectRatio(1f)
//                .matchParentSize()
                .clickable {

                }
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text, fontSize = 30.sp, style = MaterialTheme.typography.button)
            }
        }
    }
}

@Composable
fun ActionButton(text: String, modifier: Modifier = Modifier) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        val maxSize = if (this.maxHeight > this.maxWidth) this.maxWidth else this.maxHeight
        Surface(
            modifier = Modifier
                .size(maxSize)
                .padding(10.dp)
//                .matchParentSize()
                .clickable {

                },
            shape = CircleShape,
            color = MaterialTheme.colors.primary
        ) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Text(text, fontSize = 25.sp, style = MaterialTheme.typography.button)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HyperskillTheme {
        CalculatorScreen()
//        Surface(
//            modifier = Modifier
//                .fillMaxHeight()
//                .requiredWidth(800.dp)
//        ) {
//            Box(contentAlignment = Alignment.Center) {
//                Surface(modifier = Modifier.testTag("center"), color = Color.Black) {
//                    Text("left", style = TextStyle(textAlign = TextAlign.Left))
//                }
//                Text("left", style = TextStyle(textAlign = TextAlign.Left))
//                Text("center")
//                Text("right", style = TextStyle(textAlign = TextAlign.Right))
//            }
//        }
    }
}





















