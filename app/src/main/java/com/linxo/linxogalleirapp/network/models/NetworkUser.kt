package com.linxo.linxogalleirapp.network.models

import com.squareup.moshi.Json

data class NetworkUser(
    @Json(name = "id")
    val id :Int,
    @Json(name = "name")
    val name : String,
    @Json(name = "username")
    val userName : String,
    @Json(name = "email")
    val email : String,
    @Json(name = "address")
    val address : Any?,
    @Json(name = "phone")
    val phone : String,
    @Json(name = "website")
    val website : String,
    @Json(name = "company")
    val company : Any?,
)
