package com.example.rickmorty.presentation.screenCharacters

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.model.ModelCharacter
import com.example.rickmorty.domain.GetListCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenCharactersVModel @Inject constructor(private val getListCharacters: GetListCharactersUseCase) : ViewModel() {

    private val _listCharacters = mutableStateListOf<ModelCharacter>()
    val listCharacters: List<ModelCharacter> = _listCharacters

    private val _showD = MutableLiveData<Boolean>()
    val showD: MutableLiveData<Boolean> = _showD

    fun callGetList(){
        viewModelScope.launch {
            val call = getListCharacters.getListCharacters()
            if(call.body() != null){
                val list = call.body()?.results
                if (!list.isNullOrEmpty()) {
                    for (x in list.indices) {
                        _listCharacters.add(
                            ModelCharacter(
                                list[x].id,
                                list[x].name,
                                list[x].species,
                                list[x].gender,
                                list[x].location.name,
                                list[x].image
                            )
                        )
                    }
                }
            }
            dismissDialog()
        }
    }

    private fun showDialog() {
        _showD.value = true
    }

    private fun dismissDialog() {
        _showD.value = false
    }
}