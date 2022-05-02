package com.linxo.linxogalleirapp.network.models

import com.linxo.linxogalleirapp.ui.models.PictureModel
import com.squareup.moshi.Json

data class NetworkPicture(
    @Json(name = "albumId")
    val albumId :Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title : String,
    @Json(name = "url")
    val url : String,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl : String,
){
    companion object{
        fun NetworkPicture.toPictureModel(): PictureModel{
            return PictureModel(
                this.url
            )
        }
    }
}
