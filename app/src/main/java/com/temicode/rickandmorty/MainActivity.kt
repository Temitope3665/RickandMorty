package com.temicode.rickandmorty

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.temicode.rickandmorty.api.Api
import com.temicode.rickandmorty.api.ApiService
import com.temicode.rickandmorty.api.Morty
import com.temicode.rickandmorty.api.Repository
import com.temicode.rickandmorty.databinding.ActivityMainBinding
import com.temicode.rickandmorty.databinding.RickandmortyItemDisplayBinding

class MainActivity : AppCompatActivity() {

    // create binding
    private var binding: ActivityMainBinding? = null

    private var ricksandmortys = mutableListOf<Morty>()

    // ViewModel
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService))).get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)

        viewModel.rickAndMortyLiveData.observe(this, Observer {
            ricksandmortys.addAll(it)
        })

        val adapter = RickAndMortyAdapter(ricksandmortys)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)

        binding?.recyclerView?.adapter = adapter

        setupBinding(binding!!)

    }

    private fun setupBinding(binding: ActivityMainBinding) {

        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

    }
}
