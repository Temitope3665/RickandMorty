package com.temicode.rickandmorty.api

class Repository(private val apiService: ApiService) {

    suspend fun getRickAndMorty(morty: String) = apiService.getRickAndMorty(morty)

}