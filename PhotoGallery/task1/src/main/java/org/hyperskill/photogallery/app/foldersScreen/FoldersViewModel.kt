package org.hyperskill.photogallery.app.foldersScreen

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import org.hyperskill.photogallery.data.GalleryRepositoryImpl
import org.hyperskill.photogallery.domain.FolderModel
import org.hyperskill.photogallery.domain.QueryImageFoldersUseCase

private const val TAG = "ViewModel"

class FoldersViewModel(
    application: Application
) : AndroidViewModel(application) {

    init {
        Log.e(TAG, "FoldersViewModel is created ($this).")
    }

    override fun onCleared() {
        Log.e(TAG, "FoldersViewModel is cleared ($this).")
        super.onCleared()
    }
    private val contentResolver = application.contentResolver

    val foldersMap by mutableStateOf(QueryImageFoldersUseCase(GalleryRepositoryImpl(contentResolver)).invoke())

    val folderPathList by mutableStateOf(foldersMap.keys.toList())


    fun getFolderData(path: String): FolderModel {
        val name = path.substringAfterLast('/')
        val folder = foldersMap[path] ?: return FolderModel(path, name)
        val size = folder.size
        val thumbnail = folder.first()

        return FolderModel(path, name, thumbnail, size)
    }
}