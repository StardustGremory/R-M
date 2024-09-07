package com.example.rickmorty.data.service

import com.example.rickmorty.data.response.responseCharacter.ResponseCharacter
import com.example.rickmorty.data.response.responseLocations.ResponseLocations
import retrofit2.Response
import javax.inject.Inject

class ListLocationsRepository @Inject constructor(private val productService: ListLocationsService) {

    suspend fun getList(): Response<ResponseLocations> {
        return productService.getList()
    }

    suspend fun getResident(id: Int): Response<ResponseCharacter> {
        return productService.getResident(id)
    }
}