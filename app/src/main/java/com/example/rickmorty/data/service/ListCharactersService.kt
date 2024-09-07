package com.example.rickmorty.data.service

import com.example.rickmorty.data.response.responseCharacters.ResponseCharacters
import retrofit2.Response
import javax.inject.Inject

class ListCharactersService @Inject constructor(private val productClient: ListClient) {
    suspend fun getList(): Response<ResponseCharacters> {
        return productClient.getListCharacter()
    }
}