package org.hyperskill.photogallery.app.foldersScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import org.hyperskill.photogallery.app.GalleryScreens
import org.hyperskill.photogallery.domain.FolderModel
import org.hyperskill.photogallery.ui.theme.HyperskillTheme
import org.hyperskill.photogallery.R
import java.net.URLEncoder

private const val TAG = "FoldersScreen"

@Composable
fun FoldersScreen(vm: FoldersViewModel, navHostController: NavHostController) {

    val folderPathList by remember { mutableStateOf(vm.folderPathList) }
    val foldersDataList by remember {
        mutableStateOf(folderPathList.map {
            vm.getFolderData(it)
        })
    }

    FoldersContent(foldersDataList = foldersDataList, navHostController = navHostController)
}

@Composable
fun FoldersContent(foldersDataList: List<FolderModel>, navHostController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(5.dp)
    ) {
        itemsIndexed(foldersDataList) { i, folderData ->
            LaunchedEffect(key1 = true) {
                Log.e(TAG, "Lazy column calling image index: $i")
            }
            FolderItem(folderData, navHostController)
        }

    }
}


@Composable
fun FolderItem(folderData: FolderModel, navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .aspectRatio(1f)
            .fillMaxSize()
            .clickable {
                Log.e(TAG, folderData.path)
                val encodedUrl = URLEncoder.encode(folderData.path, "UTF-8")
                navHostController.navigate("${GalleryScreens.Images.name}/${encodedUrl}")
            }
    ) {
        AsyncImage(
            model = folderData.lastImage?.path,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.tail_bg),
            error = painterResource(id = R.drawable.tail_bg),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.8f))
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = folderData.name,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(15.dp).align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun FolderItemPreview() {
    val item = FolderModel(
        path = "",
        name = "Folder",
    )
    HyperskillTheme {
        FolderItem(folderData = item, navHostController = rememberNavController())
    }
}

@Preview
@Composable
fun FoldersPreview() {
    val list = List(10) {
        FolderModel(
            path = "",
            name = "Folder #$it",
        )
    }
    HyperskillTheme {
        FoldersContent(foldersDataList = list, navHostController = rememberNavController())
    }
}