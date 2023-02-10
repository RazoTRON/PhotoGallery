package org.hyperskill.photogallery.app

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.hyperskill.photogallery.app.foldersScreen.FoldersScreen
import org.hyperskill.photogallery.app.foldersScreen.FoldersViewModel
import org.hyperskill.photogallery.app.fullImage.FullImageScreen
import org.hyperskill.photogallery.app.imagesScreen.ImagesScreen
import org.hyperskill.photogallery.app.imagesScreen.ImagesViewModel
import java.net.URLDecoder

private const val TAG = "Navigation"

@Composable
fun Navigation(navController: NavHostController) {
    val application = LocalContext.current.applicationContext as Application

    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }

    NavHost(navController = navController, startDestination = GalleryScreens.Folders.name) {

        composable(GalleryScreens.Folders.name) {
            val viewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner) {
                ViewModelProvider.AndroidViewModelFactory(application)
                    .create(FoldersViewModel::class.java)
            }
            FoldersScreen(viewModel, navController)

            Log.e(TAG,
                navController.backQueue.filter { it.destination.route != null }.joinToString(prefix = "Navigated to: ")
            )
        }
        composable(
            route = "${GalleryScreens.Images.name}/{folderPath}",
            arguments = listOf(
                navArgument("folderPath") {
                    type = NavType.StringType
                }
            )
        ) {
            val foldersViewModel = viewModel(viewModelStoreOwner = viewModelStoreOwner) {
                ViewModelProvider.AndroidViewModelFactory(application)
                    .create(FoldersViewModel::class.java)
            }

            val imagesViewModel = viewModel() {
                ViewModelProvider.AndroidViewModelFactory(application)
                    .create(ImagesViewModel::class.java)
            }

            val folderPath = it.arguments?.getString("folderPath") ?: ""
            val decodedUrl = URLDecoder.decode(folderPath, "UTF-8")
            ImagesScreen(decodedUrl, imagesViewModel, foldersViewModel, navController)

            Log.e(TAG,
                navController.backQueue.filter { it.destination.route != null }.joinToString(prefix = "Navigated to: ")
            )
        }
        composable(
            route = "${GalleryScreens.FullImage.name}/{imagePath}",
            arguments = listOf(
                navArgument("imagePath") {
                    type = NavType.StringType
                }
            )
        ) {
            val imagePath = it.arguments?.getString("imagePath") ?: ""
            val decodedUrl = URLDecoder.decode(imagePath, "UTF-8")
            FullImageScreen(decodedUrl, navController)

            Log.e(TAG,
                navController.backQueue.filter { it.destination.route != null }.joinToString(prefix = "Navigated to: ")
            )
        }
    }
}