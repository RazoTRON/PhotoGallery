package org.hyperskill.photogallery.app.imagesScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.hyperskill.photogallery.app.GalleryScreens
import org.hyperskill.photogallery.app.foldersScreen.FoldersViewModel
import java.net.URLEncoder
import org.hyperskill.photogallery.R

private const val TAG = "ImagesScreen"

@Composable
fun ImagesScreen(folderPath: String, vm: ImagesViewModel, folderVm: FoldersViewModel, navHostController: NavHostController) {

    val imagesList by remember { mutableStateOf(folderVm.foldersMap[folderPath] ?: emptyList()) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(5.dp)
    ) {
        itemsIndexed(imagesList) { i, imagesModel ->
            LaunchedEffect(key1 = true) {
                Log.e(TAG, "Lazy column calling image index: $i")
            }
            PhotoItem(imagesModel.path, navHostController)
        }

    }
}

@Composable
fun PhotoItem(url: String, navHostController: NavHostController) {
    Surface(shape = RoundedCornerShape(25.dp)) {
        AsyncImage(
            model = url,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.tail_bg),
            error = painterResource(id = R.drawable.tail_bg),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clickable {
                    val route = URLEncoder.encode(url, "UTF-8")
                    navHostController.navigate("${GalleryScreens.FullImage.name}/$route")
                }
        )
    }
}