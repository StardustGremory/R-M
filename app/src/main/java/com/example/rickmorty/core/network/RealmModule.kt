package com.example.rickmorty.core.network

import android.content.Context
import com.example.rickmorty.data.daosRealm.DaoCharacter
import com.example.rickmorty.data.daosRealm.DaoCharacterImpl
import com.example.rickmorty.data.modelRealm.CharacterModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RealmModule {

    @Provides
    fun provideRealm(): Realm {
        val realmConfig = RealmConfiguration.create(
            schema = setOf(
                CharacterModel::class,
            )
        )
        return Realm.open(realmConfig)
    }

}