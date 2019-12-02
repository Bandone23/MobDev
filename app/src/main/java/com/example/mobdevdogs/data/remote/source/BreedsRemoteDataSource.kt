package com.example.mobdevdogs.data.remote.source

import com.example.core.extension.await
import com.example.mobdevdogs.data.remote.modelo.BreedsEntry
import com.example.mobdevdogs.data.remote.net.BreedsRemoteApi

class BreedsRemoteDataSource(
    private val remoteApi: BreedsRemoteApi
) {

    suspend fun getBreeds():BreedsEntry {
        return remoteApi.getBreeds().await()!!
    }
}