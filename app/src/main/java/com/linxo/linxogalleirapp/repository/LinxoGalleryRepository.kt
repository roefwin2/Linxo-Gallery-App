package com.linxo.linxogalleirapp.repository

import com.linxo.linxogalleirapp.network.api.AlbumsApi
import com.linxo.linxogalleirapp.utils.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class LinxoGalleryRepository @Inject constructor(
    private val albumsApi: AlbumsApi
) {

    suspend fun getAlbums() = flow {
        emit(Resource.Loading)
        try {
            val result = albumsApi.getAlbums()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))

        }
    }

    suspend fun getUsers() = flow {
        emit(Resource.Loading)
        try {
            val result = albumsApi.getUsers()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))

        }
    }

    suspend fun getPictures(albumId : Int) = flow {
        emit(Resource.Loading)
        try {
            val result = albumsApi.getPictures(albumId)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))

        }
    }
}