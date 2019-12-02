package com.example.mobdevdogs.domain.usecase

import com.example.core.coroutines.ResultUnitUseCase
import com.example.mobdevdogs.data.repository.BreedsRepository
import com.example.mobdevdogs.domain.model.Breeds
import kotlinx.coroutines.Dispatchers

class GetBreedsUseCase(
    private val repository: BreedsRepository
) : ResultUnitUseCase<Breeds>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): Breeds? {
        return repository.getBreeds()
    }

}
