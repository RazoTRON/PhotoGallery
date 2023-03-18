package org.hyperskill.photogallery.app.imagesScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel

private const val TAG = "ViewModel"

class ImagesViewModel(
    application: Application
) : AndroidViewModel(application) {

    init {
        Log.e(TAG, "ImagesViewModel is created ($this).")
    }

    override fun onCleared() {
        Log.e(TAG, "ImagesViewModel is cleared ($this).")
        super.onCleared()
    }
}