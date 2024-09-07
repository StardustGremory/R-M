package com.example.rickmorty.domain

import com.example.rickmorty.data.response.responseCharacters.ResponseCharacters
import com.example.rickmorty.data.service.ListCharactersRepository
import retrofit2.Response
import javax.inject.Inject

class GetListCharactersUseCase @Inject constructor(private val listRepository: ListCharactersRepository) {
    suspend fun getListCharacters(): Response<ResponseCharacters> {
        return listRepository.getList()
    }
}