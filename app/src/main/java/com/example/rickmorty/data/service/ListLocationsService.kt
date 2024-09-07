package com.example.rickmorty.data.service

import com.example.rickmorty.data.response.responseCharacter.ResponseCharacter
import com.example.rickmorty.data.response.responseLocations.ResponseLocations
import retrofit2.Response
import javax.inject.Inject

class ListLocationsService @Inject constructor(private val productClient: ListClient){

    suspend fun getList(): Response<ResponseLocations> {
        return productClient.getListLocation()
    }

    suspend fun getResident(id: Int): Response<ResponseCharacter> {
        return productClient.getCharacter(id.toString())
    }
}