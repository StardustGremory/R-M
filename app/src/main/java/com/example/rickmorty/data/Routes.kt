package com.example.rickmorty.data

sealed class Routes(val route: String) {
    object ScreenCharacters: Routes("screenCharacters")
    object ScreenLocations: Routes("screenLocations")
    object ScreenEpisodes: Routes("screenEpisodes")
}

