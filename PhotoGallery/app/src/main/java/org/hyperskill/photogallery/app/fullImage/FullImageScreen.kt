package org.hyperskill.photogallery.app.fullImage

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Size
import org.hyperskill.photogallery.R

private const val TAG = "FullImageScreen"


@Composable
fun FullImageScreen(imagePath: String, navHostController: NavHostController) {
    Log.e(TAG, "Request full image by path: $imagePath")
    val request = ImageRequest.Builder(LocalContext.current)
        .data(imagePath)
        .size(Size.ORIGINAL)
        .precision(Precision.INEXACT)
        .build()

    var offset by remember { mutableStateOf(Offset.Zero) }

    var scale by remember { mutableStateOf(1f) }

    var size by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }

    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 1f)
        ) {
            AsyncImage(
                model = request,
                contentDescription = null,
                placeholder = rememberAsyncImagePainter(model = imagePath, imageLoader = ImageLoader.Builder(
                    LocalContext.current)
                    .precision(Precision.INEXACT)
                    .build()),
                error = painterResource(id = R.drawable.tail_bg),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .onSizeChanged {
                        size = it.toSize()
                    }
                    .graphicsLayer(
                        translationX = offset.x,
                        translationY = offset.y,
                        scaleX = scale,
                        scaleY = scale
                    )
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->

                            val newScale = (zoom * scale).coerceIn(1f, 5f)
                            val newOffset = offset + (pan * scale)
                            scale = newScale

                            val maxX = (size.width * (scale - 1) / 2f)
                            val maxY = (size.height * (scale - 1) / 2f)

                            offset = Offset(
                                newOffset.x.coerceIn(-maxX, maxX),
                                newOffset.y.coerceIn(-maxY, maxY)
                            )


                        }
                        detectTapGestures(
                            onDoubleTap = {
                                scale = when {
                                    scale > 2f -> 1f
                                    else -> 3f
                                }
                            }
                        )
                    }
            )
        }
//        Text(text = "Size height: ${size.height}")
//        Text(text = "Size Width: ${size.width}")
//        Text(text = "Scale: $scale")
    }
}


@Preview
@Composable
fun test() {
    FullImageScreen("", rememberNavController())
}