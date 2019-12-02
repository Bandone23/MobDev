package com.example.mobdevdogs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mobdevdogs.R
import com.example.mobdevdogs.databinding.ItemBreedsBinding
import com.example.mobdevdogs.ui.adapter.holder.BreedsNHolder

class RecyclerBreedsNAdapter(
    private var data:List<String>
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding:ItemBreedsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_breeds,parent,false
            )
        return BreedsNHolder(itemBinding)
    }
    override fun getItemCount(): Int {
       return data.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        holder as BreedsNHolder
        holder.bindEvent(item)
    }

    fun setData(breeds: List<String>) {
        this.data =breeds
        notifyDataSetChanged()
    }

}