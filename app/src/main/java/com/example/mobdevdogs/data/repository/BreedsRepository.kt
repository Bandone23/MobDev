package com.example.mobdevdogs.data.repository

import com.example.mobdevdogs.data.remote.modelo.toBreeds
import com.example.mobdevdogs.data.remote.source.BreedsRemoteDataSource
import com.example.mobdevdogs.domain.model.Breeds

class BreedsRepository(
    private val breedsRemoteDataSource: BreedsRemoteDataSource
) {
    //TODO call remote

    suspend fun getBreeds(): Breeds {
        return breedsRemoteDataSource.getBreeds().toBreeds()
    }
}