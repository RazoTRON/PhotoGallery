package org.hyperskill.photogallery.domain

import android.util.Log
import org.hyperskill.photogallery.data.ImageModel

private const val TAG = "GetFolderDataUseCase"

class GetFolderDataUseCase(val repository: GalleryRepository) {
    fun invoke(folderPath: String): FolderModel {
        Log.e(TAG, "GetFolderDataUseCase")
        val allFoldersWithImages = QueryImageFoldersUseCase(repository = repository).invoke()
        val folderName: String = folderPath.substringAfterLast('/')
        val folderSize = allFoldersWithImages[folderPath]?.size
        val folderThumbnail = allFoldersWithImages[folderPath]?.firstOrNull()

        return FolderModel(
            path = folderPath,
            name = folderName,
            lastImage = folderThumbnail,
            size = folderSize
        )
    }
}

data class FolderModel(val path: String, val name: String, val lastImage: ImageModel? = null, val size: Int? = null) {

}