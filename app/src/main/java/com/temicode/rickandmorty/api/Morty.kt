package com.temicode.rickandmorty.api

import com.squareup.moshi.Json

class Morty(

    @Json(name = "name")
    val mortyName: String,

    @Json(name = "status")
    val mortyStatus: String,

    @Json(name = "species")
    val mortySpecie: String,

    @Json(name = "image")
    val mortyImage: String

)