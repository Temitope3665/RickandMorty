package com.temicode.rickandmorty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.temicode.rickandmorty.api.Morty
import com.temicode.rickandmorty.api.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    private val _rickAndMortyLiveData = MutableLiveData<List<Morty>>()

    val rickAndMortyLiveData:LiveData<List<Morty>>
    get() = _rickAndMortyLiveData

    init {

        getRickAndMorty()

    }

    private fun getRickAndMorty() {

        viewModelScope.launch {

            try {
                // Add the query here
                _rickAndMortyLiveData.value =  repository.getRickAndMorty("page").results
                Log.d(TAG, "${_rickAndMortyLiveData.value}")
            } catch(e:Exception) {
                Log.d(TAG, e.message.toString())
            }

        }
    }

}