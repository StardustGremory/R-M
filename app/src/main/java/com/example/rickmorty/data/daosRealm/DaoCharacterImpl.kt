package com.example.rickmorty.data.daosRealm

import com.example.rickmorty.data.modelRealm.CharacterModel
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import javax.inject.Inject

class DaoCharacterImpl @Inject constructor(private val realm: Realm): DaoCharacter{
    override suspend fun insertCharacter(user: CharacterModel) {
        realm.write {
            copyToRealm(user, UpdatePolicy.ALL)
        }
    }

    override suspend fun getAllCharacter(): List<CharacterModel> {
        return realm.query(CharacterModel::class).find()
    }


}

interface DaoCharacter{
    suspend fun insertCharacter(user: CharacterModel)
    suspend fun getAllCharacter(): List<CharacterModel>
}