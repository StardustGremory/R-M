package com.example.rickmorty.presentation.screenLocations

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.daosRealm.CharacterRepository
import com.example.rickmorty.data.modelRealm.CharacterModel
import com.example.rickmorty.data.response.responseCharacter.ResponseCharacter
import com.example.rickmorty.data.response.responseLocations.Result
import com.example.rickmorty.domain.GetListLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenLocationsVModel @Inject constructor(
    private val getListLocations: GetListLocationsUseCase,
    private val characterRepositoryDB: CharacterRepository
) : ViewModel() {


    private val _listLocations = mutableStateListOf<CharacterModel>()
    val listLocations: List<CharacterModel> = _listLocations

    private val _showD = MutableLiveData<Boolean>()
    val showD: MutableLiveData<Boolean> = _showD

    fun callGetList(){
        viewModelScope.launch {
            val call = getListLocations.getListLocations()
            if(call.body() != null){
                val list = call.body()?.results
                if (!list.isNullOrEmpty()) {
                    //Save locations and residents
                    for (x in list.indices){
                        for (y in list[x].residents.indices){
                            val callResident = getListLocations.getResident(extractFirstNumber(list[x].residents[y]))
                            if(callResident.body() != null){
                                callSaveList(list[x], callResident.body()!!)
                            }
                        }

                    }
                }
            }
        }
    }

    private suspend fun callSaveList(list: Result, body: ResponseCharacter) {
        characterRepositoryDB.insertCharacter(
            CharacterModel(
                body.id, body.name, body.species, body.gender, body.image, list.id, list.name, list.type, list.dimension, list.created
            )
        )

    }

   fun callReadList() {
        viewModelScope.launch {
            val listCharacter  = characterRepositoryDB.getAll()
            for (x in listCharacter.indices) {
                _listLocations.add(listCharacter[x])
            }
            dismissDialog()
        }
    }

    private fun extractFirstNumber(input: String): Int {
        // Utilizamos una expresión regular para encontrar números
        val regex = "\\d+".toRegex()

        // Buscamos el primer número encontrado y lo convertimos a entero
        return regex.find(input)?.value?.toInt() ?: 0
    }


    fun showDialog() {
        _showD.value = true
    }

    fun dismissDialog() {
        _showD.value = false
    }
}