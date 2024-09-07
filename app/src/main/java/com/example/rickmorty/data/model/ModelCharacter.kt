package com.example.rickmorty.data.model

data class ModelCharacter(val id: Int, val name: String, val species: String, val gender: String, val location: String = "Unknown", val image: String)
