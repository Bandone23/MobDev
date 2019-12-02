package com.example.mobdevdogs.data.remote.modelo

import com.example.mobdevdogs.domain.model.Breeds

data class BreedsEntry (
    val message:List<String>,
    val status :String

)
fun BreedsEntry.toBreeds()= Breeds (
    message=message,
    status = status
)