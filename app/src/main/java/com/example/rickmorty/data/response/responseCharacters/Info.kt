package com.example.rickmorty.data.response.responseCharacters

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)