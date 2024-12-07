package com.example.planetapp

import com.example.planetapp.navigation.NavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavGraph(
                onSettingsClick = {},
                onHelpClick = {}
            )
        }
    }
}

