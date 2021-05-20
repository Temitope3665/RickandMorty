package com.temicode.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.loadAny
import com.temicode.rickandmorty.api.Morty
import com.temicode.rickandmorty.databinding.RickandmortyItemDisplayBinding

class RickAndMortyAdapter(private val ricksandmortys: List<Morty>): RecyclerView.Adapter<RickAndMortyAdapter.RickAndMortyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(RickandmortyItemDisplayBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        holder.bindItem(ricksandmortys[position])

    }

    override fun getItemCount(): Int {
        return ricksandmortys.size
    }


    inner class RickAndMortyViewHolder(private val binding: RickandmortyItemDisplayBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(morty: Morty) {
            binding.inputName.text = morty.mortyName
            binding.inputStatus.text = morty.mortyStatus
            binding.inputSpecie.text = morty.mortySpecie
            binding.myImage.load(morty.mortyImage)
        }

    }
}