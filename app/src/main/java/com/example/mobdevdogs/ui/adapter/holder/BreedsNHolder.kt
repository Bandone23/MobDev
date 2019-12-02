package com.example.mobdevdogs.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.mobdevdogs.databinding.ItemBreedsBinding

class BreedsNHolder(
    private val binding:ItemBreedsBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(breedsData:String) {
        binding.breeds = breedsData

        binding.executePendingBindings()
    }

}