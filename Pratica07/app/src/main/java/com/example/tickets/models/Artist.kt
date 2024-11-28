package com.example.tickets.models

import com.example.tickets.R

data class Artist(
    val id: Int,
    val name: String,
    val gender: String,
    val description: String,
    val imageRes: Int,
    val ticketPrice: Double, // Novo campo adicionado
    var isFavorite: Boolean = false,
)
val artistsList = listOf(
    Artist(
        id = 1,
        name = "Taylor Swift",
        gender = "Pop",
        description = "Taylor Swift é uma das artistas mais influentes da música contemporânea, conhecida por suas letras narrativas e transformações de estilo.",
        imageRes = R.drawable.taylor_swift,
        ticketPrice = 350.0, // Preço do ingresso
        isFavorite = true
    ),
    Artist(
        id = 2,
        name = "Ed Sheeran",
        gender = "Pop/Folk",
        description = "Ed Sheeran é um cantor e compositor britânico, conhecido por seus sucessos melódicos e letras românticas.",
        imageRes = R.drawable.ed_sheeran,
        ticketPrice = 280.0, // Preço do ingresso
        isFavorite = false
    ),
    Artist(
        id = 3,
        name = "Adele",
        gender = "Soul/Pop",
        description = "Adele é reconhecida por sua poderosa voz e baladas emocionantes que alcançaram fãs em todo o mundo.",
        imageRes = R.drawable.adele,
        ticketPrice = 400.0, // Preço do ingresso
        isFavorite = true
    ),
    Artist(
        id = 4,
        name = "The Weeknd",
        gender = "R&B/Pop",
        description = "The Weeknd é um cantor e compositor conhecido por suas músicas inovadoras que misturam gêneros como R&B, pop e eletrônica.",
        imageRes = R.drawable.the_weeknd,
        ticketPrice = 320.0, // Preço do ingresso
        isFavorite = false
    ),
    Artist(
        id = 5,
        name = "Beyoncé",
        gender = "Pop/R&B",
        description = "Beyoncé é uma das maiores artistas de todos os tempos, com performances memoráveis e hits icônicos.",
        imageRes = R.drawable.beyonce,
        ticketPrice = 450.0, // Preço do ingresso
        isFavorite = true
    ),
    Artist(
        id = 6,
        name = "Bruno Mars",
        gender = "Pop/Funk",
        description = "Bruno Mars é um artista versátil que combina estilos como funk, pop e R&B em suas músicas animadas e cheias de groove.",
        imageRes = R.drawable.bruno_mars,
        ticketPrice = 300.0, // Preço do ingresso
        isFavorite = false
    ),
    Artist(
        id = 7,
        name = "Billie Eilish",
        gender = "Alternative/Pop",
        description = "Billie Eilish é uma cantora e compositora premiada, conhecida por seu estilo único e músicas introspectivas.",
        imageRes = R.drawable.billie_eilish,
        ticketPrice = 250.0, // Preço do ingresso
        isFavorite = false
    ),
    Artist(
        id = 8,
        name = "Drake",
        gender = "Hip-Hop/Rap",
        description = "Drake é um dos maiores nomes do rap, conhecido por seus hits que misturam rap e melodias suaves.",
        imageRes = R.drawable.drake,
        ticketPrice = 380.0, // Preço do ingresso
        isFavorite = true
    )
)
