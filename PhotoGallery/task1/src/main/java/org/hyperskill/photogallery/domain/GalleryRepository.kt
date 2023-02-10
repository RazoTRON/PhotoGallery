package org.hyperskill.photogallery.domain

import org.hyperskill.photogallery.data.ImageModel

interface GalleryRepository {
    fun queryAllImages(): List<ImageModel>
}