package com.example.rickmorty.data.service

import com.example.rickmorty.data.response.responseCharacter.ResponseCharacter
import com.example.rickmorty.data.response.responseCharacters.ResponseCharacters
import com.example.rickmorty.data.response.responseEpisodes.ResponseEpisodes
import com.example.rickmorty.data.response.responseLocations.ResponseLocations
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ListClient {
    //Characters
    @GET("api/character")
    suspend fun getListCharacter(): Response<ResponseCharacters>
    //Locations
    @GET("api/location")
    suspend fun getListLocation(): Response<ResponseLocations>
    //Character
    @GET("api/character/{id}")
    suspend fun getCharacter(@Path("id") characterId: String): Response<ResponseCharacter>
}