package com.example.rickmorty.data.daosRealm

import com.example.rickmorty.data.modelRealm.CharacterModel
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterDaoCharacter: DaoCharacterImpl){

    suspend fun insertCharacter(characterModel: CharacterModel){
        characterDaoCharacter.insertCharacter(characterModel)
    }

    suspend fun getAll(): List<CharacterModel> = characterDaoCharacter.getAllCharacter()
}