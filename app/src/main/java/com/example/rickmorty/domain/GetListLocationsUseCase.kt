package com.example.rickmorty.domain

import com.example.rickmorty.data.response.responseCharacter.ResponseCharacter
import com.example.rickmorty.data.response.responseLocations.ResponseLocations
import com.example.rickmorty.data.service.ListLocationsRepository
import retrofit2.Response
import javax.inject.Inject

class GetListLocationsUseCase @Inject constructor(private val listRepository: ListLocationsRepository) {

    suspend fun getListLocations(): Response<ResponseLocations> {
        return listRepository.getList()
    }

    suspend fun getResident(id: Int): Response<ResponseCharacter> {
        return listRepository.getResident(id)
    }
}