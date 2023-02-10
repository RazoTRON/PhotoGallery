package org.hyperskill.photogallery.domain

import android.util.Log
import org.hyperskill.photogallery.data.ImageModel

private const val TAG = "QueryImageFolders"

class QueryImageFoldersUseCase(val repository: GalleryRepository) {
    fun invoke(): Map<String, MutableList<ImageModel>>{
        Log.e(TAG, "Querying Image Folders Storage...")
        val imageList = QueryAllImagesUseCase(repository).invoke()
        val imageListByFolders = mutableMapOf<String, MutableList<ImageModel>>()

        imageList.map {
            val path = it.path.substringBeforeLast('/')
            Log.e(TAG, "Adding folder to folders list (path: $path).")
            if (imageListByFolders[path].isNullOrEmpty()) {
                imageListByFolders[path] = mutableListOf(it)
                Log.e(TAG, "Adding new folder and an image to folder (path: $path).")
            } else {
                imageListByFolders[path]?.add(it)
                Log.e(TAG, "Adding an image to folder (path: $path).")
            }
        }
        Log.e(TAG, "Returning folders map with list of ImageData")
        return imageListByFolders
    }
}