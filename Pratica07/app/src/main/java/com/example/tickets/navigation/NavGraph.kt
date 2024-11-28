package com.example.tickets.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tickets.ui.screens.ArtistScreen
import com.example.tickets.ui.screens.HomeScreen
import com.example.tickets.models.artistsList

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onArtistSelected = { artist ->
                navController.navigate("artist/${artist.name}")
            })
        }
        composable("artist/{artist}") { backStackEntry ->
            val artistName = backStackEntry.arguments?.getString("artist")
            val selectedArtist = artistsList.first { it.name == artistName }
            ArtistScreen(selectedArtist)
        }
    }
}

