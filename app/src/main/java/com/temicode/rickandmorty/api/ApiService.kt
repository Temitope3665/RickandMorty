package com.temicode.rickandmorty.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://www.rickandmortyapi.com/api/
//https://www.rickandmortyapi.com/api/character
// https://www.rickandmortyapi.com/api/character?page=2
// https://www.rickandmortyapi.com/api/character?page=2

private val BASE_URL = "https://rickandmortyapi.com/"

interface ApiService{

    @GET("api/character")
    suspend fun getRickAndMorty(@Query("page")morty: String): MortyResponse

}

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

object Api{
    val apiService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


