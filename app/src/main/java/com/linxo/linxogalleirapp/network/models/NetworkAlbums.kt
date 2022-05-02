package com.linxo.linxogalleirapp.network.models

import com.squareup.moshi.Json

data class NetworkAlbums(
    @Json(name = "userId")
    val userId :Int,
    @Json(name = "id")
    val id : Int,
    @Json(name = "title")
    val title: String
)
