package com.example.rickmorty

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickmorty.data.Routes
import com.example.rickmorty.presentation.screenCharacters.ScreenCharacters
import com.example.rickmorty.presentation.screenCharacters.ScreenCharactersVModel
import com.example.rickmorty.presentation.screenLocations.ScreenLocations
import com.example.rickmorty.presentation.screenLocations.ScreenLocationsVModel
import com.example.rickmorty.ui.theme.RickMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val screenCharactersVModel: ScreenCharactersVModel by viewModels()
    private val screenLocationsVModel: ScreenLocationsVModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RickMortyTheme {

                val snackbarHostState = remember { SnackbarHostState() }
                val navigationCont = rememberNavController()

                Scaffold(
                    bottomBar = { MyBottomNavigation(navigationCont) },
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    content = { NavigationGraph(navigationCont = navigationCont) }
                )
            }
        }
    }

    @Composable
    fun NavigationGraph(navigationCont: NavHostController) {

        NavHost(navController = navigationCont, startDestination = Routes.ScreenCharacters.route){
            composable(Routes.ScreenCharacters.route){
                ScreenCharacters(screenCharactersVModel)
            }
            composable(Routes.ScreenLocations.route){
                ScreenLocations(screenLocationsVModel)
            }
        }
    }

    @Composable
    fun MyBottomNavigation(navigationCont: NavHostController) {

        var index by rememberSaveable { mutableStateOf(0) }

        NavigationBar(containerColor = Color.Black) {
            NavigationBarItem(
                selected = index == 0,
                onClick = {
                    index = 0
                    navigationCont.navigate(Routes.ScreenCharacters.route)
                },
                label = { Text(text = "Characters", color = Color.White) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Characters",
                        tint = Color.White
                    )
                }
            )
            NavigationBarItem(
                selected = index == 1,
                onClick = {
                    index = 1
                    navigationCont.navigate(Routes.ScreenLocations.route)
                },
                label = { Text(text = "Locations",color = Color.White) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Locations",
                        tint = Color.White
                    )
                }
            )
        }
    }
}

