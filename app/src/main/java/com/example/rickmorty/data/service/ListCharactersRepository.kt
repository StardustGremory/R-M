package com.example.rickmorty.data.service

import com.example.rickmorty.data.response.responseCharacters.ResponseCharacters
import retrofit2.Response
import javax.inject.Inject

class ListCharactersRepository @Inject constructor(private val productService: ListCharactersService) {
    suspend fun getList(): Response<ResponseCharacters> {
        return productService.getList()
    }
}