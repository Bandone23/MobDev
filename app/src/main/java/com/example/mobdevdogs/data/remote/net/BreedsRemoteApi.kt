package com.example.mobdevdogs.data.remote.net

import com.example.mobdevdogs.data.remote.modelo.BreedsEntry
import retrofit2.Call
import retrofit2.http.GET

interface BreedsRemoteApi {
    @GET("breeds/list")
    fun getBreeds(): Call<BreedsEntry>
}