package com.example.mobdevdogs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.mobdevdogs.domain.model.Breeds
import com.example.mobdevdogs.domain.usecase.GetBreedsUseCase
import com.example.mobdevdogs.ui.adapter.RecyclerBreedsNAdapter

class BreedsViewModel (
    private val getBreedsUseCase: GetBreedsUseCase
) : ViewModel() {
    lateinit var adapter: RecyclerBreedsNAdapter
    val breedsLiveData = LiveResult<Breeds>()


    fun getBreeds(){
        getBreedsUseCase.execute(liveData = breedsLiveData)
    }

  fun initAdapter(breeds: List<String>){
      adapter = RecyclerBreedsNAdapter(breeds)
  }
    fun updateBreeds(breeds: List<String>) {
       adapter.setData(breeds)
        adapter.notifyDataSetChanged()
    }

}