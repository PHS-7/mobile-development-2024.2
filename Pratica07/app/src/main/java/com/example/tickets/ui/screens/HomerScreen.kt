package com.example.tickets.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.tickets.models.Artist
import com.example.tickets.models.artistsList
import com.example.tickets.ui.components.SingerListItem

@Composable
fun HomeScreen(onArtistSelected: (Artist) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredArtist = remember(searchQuery) {
        artistsList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }
    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(filteredArtist) { animal ->
                SingerListItem(animal, onArtistSelected)
            }
        }
    }
}

