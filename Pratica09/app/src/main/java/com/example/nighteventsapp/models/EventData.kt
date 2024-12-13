package com.example.nighteventsapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Conferência de Tecnologia 2024",
        description = "Tendências em tecnologia",
        date = "2024-12-15",
        location = "Parque Tecnológico",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img1
    ),
    Event(
        id = 2,
        title = "Workshop de Desenvolvimento Mobile",
        description = "Aprenda sobre o desenvolvimento de aplicativos Android e iOS.",
        date = "2024-12-20",
        location = "Centro de Convenções",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img2
    ),
    Event(
        id = 3,
        title = "Feira de Inovação e Startups",
        description = "Explore startups e soluções inovadoras.",
        date = "2025-01-10",
        location = "Espaço de Inovação",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img3
    ),
    Event(
        id = 4,
        title = "Hackathon Nacional 2024",
        description = "Competição de programação para resolver problemas reais.",
        date = "2024-12-30",
        location = "Campus Universitário",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img4
    ),
    Event(
        id = 5,
        title = "Simpósio de Inteligência Artificial",
        description = "Discussões sobre o impacto da IA em diferentes setores.",
        date = "2025-01-15",
        location = "Auditório Principal",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img5
    ),
    Event(
        id = 6,
        title = "Palestra: Futuro do Blockchain",
        description = "Entenda as aplicações do blockchain além das criptomoedas.",
        date = "2025-01-20",
        location = "Sala de Conferências",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img6
    ),
    Event(
        id = 7,
        title = "Encontro de Desenvolvedores Web",
        description = "Técnicas e tendências para desenvolvimento web moderno.",
        date = "2025-02-05",
        location = "Hub de Tecnologia",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img7
    ),
    Event(
        id = 8,
        title = "Semana de Cibersegurança",
        description = "Workshops e palestras sobre proteção digital.",
        date = "2025-02-10",
        location = "Centro de Treinamento",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img8
    ),
    Event(
        id = 9,
        title = "Fórum de Sustentabilidade e Tecnologia",
        description = "Inovações tecnológicas para um futuro sustentável.",
        date = "2025-03-01",
        location = "Centro Verde",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img9
    ),
    Event(
        id = 10,
        title = "Oficina de Realidade Virtual",
        description = "Experimente e desenvolva aplicações de realidade virtual.",
        date = "2025-03-10",
        location = "Laboratório de Inovação",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img10
    )
)
