package org.hyperskill.photogallery.domain

import org.hyperskill.photogallery.data.ImageModel

class QueryAllImagesUseCase(val repository: GalleryRepository) {
    fun invoke(): List<ImageModel> {
        return repository.queryAllImages()
    }
}