package com.apppost2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.apppost2.ui.screens.PostScreen
import com.apppost2.ui.screens.UserScreen
import com.apppost2.ui.theme.PrimaryLight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { "PostApp" },
                backgroundColor = PrimaryLight,
                contentColor = Color.White
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = PrimaryLight
            ) {
                BottomNavigationItem(
                    selected = selectTab == 0,
                    onClick = { selectTab = 0 },
                    label = { Text(text = "Usuários") },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Usuarios") }
                )

                BottomNavigationItem(
                    selected = selectTab == 1,
                    onClick = { selectTab = 1 },
                    label = { Text(text = "Posts") },
                    icon = { Icon(Icons.Default.List, contentDescription = "Posts") }
                )
            }
        }
    ) {
        when (selectTab) {
            0 -> UserScreen()
            1 -> PostScreen()
        }
    }
}