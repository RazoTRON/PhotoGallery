package org.hyperskill.photogallery.data

import android.content.ContentResolver
import android.content.ContentUris
import android.provider.MediaStore
import android.util.Log
import org.hyperskill.photogallery.domain.GalleryRepository


private const val TAG = "GalleryRepositoryImpl"

class GalleryRepositoryImpl(
    val contentResolver: ContentResolver
) : GalleryRepository {

    override fun queryAllImages(): List<ImageModel> {
        Log.e(TAG, "Querying Image Storage...")
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        Log.e(TAG, "Uri: $uri")

        Log.e(TAG, "Getting Image projection...")
        val imageProjection = arrayOf(
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA
        )

        val imageSortOrder = "${MediaStore.Images.Media.DATE_TAKEN} DESC"
        Log.e(TAG, "Image sort order: $imageSortOrder")

        val cursor = contentResolver.query(
            uri,
            imageProjection,
            null,
            null,
            imageSortOrder
        )
        Log.e(TAG, "Query is finished!")

        val list = mutableListOf<ImageModel>()

        cursor.use {
            it?.let {
                Log.e(TAG, "Listing...")
                val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                Log.e(TAG, "ID Column index: $idColumn!")
                val nameColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                Log.e(TAG, "Name Column index: $nameColumn!")
                val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
                Log.e(TAG, "Size Column index: $sizeColumn!")
                val dateColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)
                Log.e(TAG, "Date Column index: $dateColumn!")
                val pathColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                Log.e(TAG, "Path Column index: $pathColumn!")


                if (!it.moveToNext()) {
                    Log.e(TAG, "Failed to move cursor to first row (no query results).")
                    return emptyList()
                }

                do {
                    val id = it.getLong(idColumn)
                    val name = it.getString(nameColumn)
                    val size = it.getString(sizeColumn)
                    val dateTaken = it.getString(dateColumn)
                    val path = it.getString(pathColumn)
                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    Log.e(
                        TAG, "Image ID: $id, name: $name ($size kb), $dateTaken" +
                                "\npath: $path" +
                                "\ncontentUri: $contentUri"
                    )

                    list.add(
                        ImageModel(
                            path = path,
                            name = name,
                            size = size,
                            dateTaken = dateTaken
                        )
                    )
                    Log.e(TAG, "Added to image pathList!")

                     // TODO (generate the thumbnail)
                    // val thumbnail = context.contentResolver.loadThumbnail(contentUri, Size(480, 480), null)
                } while (it.moveToNext())

            } ?: kotlin.run {
                Log.e(TAG, "Cursor is null!")
            }
        }
        Log.e(TAG, "Returning pathList of Images.")
        return list
    }

}