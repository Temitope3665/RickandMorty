package com.temicode.rickandmorty.api

class Repository(private val apiService: ApiService) {

    suspend fun getRickAndMorty(rickandMorty: String) = apiService.getRickAndMorty(rickandMorty)

}