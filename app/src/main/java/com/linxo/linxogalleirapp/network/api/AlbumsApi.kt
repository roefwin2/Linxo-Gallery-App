package com.linxo.linxogalleirapp.network.api

import com.linxo.linxogalleirapp.network.models.NetworkAlbums
import com.linxo.linxogalleirapp.network.models.NetworkPicture
import com.linxo.linxogalleirapp.network.models.NetworkUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumsApi {
    @GET("albums")
    suspend fun getAlbums() : List<NetworkAlbums>

    @GET("users")
    suspend fun getUsers() : List<NetworkUser>

    @GET("photos")
    suspend fun getPictures(@Query("albumId") albumId: Int) : List<NetworkPicture>
}