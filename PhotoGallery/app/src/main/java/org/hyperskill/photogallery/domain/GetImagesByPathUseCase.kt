package org.hyperskill.photogallery.domain

import android.util.Log
import org.hyperskill.photogallery.data.ImageModel
import java.io.File

private const val TAG = "GetImagesByPathUseCase"

class GetImagesByPathUseCase(val repository: GalleryRepository) {
    fun invoke(path: String): List<ImageModel> {
        val folderAndImages = QueryImageFoldersUseCase(repository).invoke()

        Log.e(TAG, "Getting images from path: $path...")
        val folder = File(path)
        if (!folder.exists() && !folder.isDirectory) {
            Log.e(TAG, "Folder doesn't exist or isn't a directory (path: $path)")
            throw NullPointerException()
        }
        if (folderAndImages[path].isNullOrEmpty()) {
            Log.e(TAG, "Folder is empty (path: $path).")
            return emptyList()
        }
        Log.e(TAG, "Returning images from folder (path: $path).")
        return folderAndImages[path]!!.toList()
    }
}