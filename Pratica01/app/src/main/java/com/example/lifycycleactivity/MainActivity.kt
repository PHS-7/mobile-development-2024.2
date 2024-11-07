package com.example.lifycycleactivity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifycycleactivity.ui.theme.LifyCycleActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifyCycleActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d("LifecycleDemo", "onCreate chamado(estamos no log)")
        Toast.makeText(this, "onCreate chamado", Toast.LENGTH_SHORT).show()

    }
    override fun onStart() {
        super.onStart()

        // Mensagem de log e Toast para onStart
        Log.d("LifecycleDemo", "onStart chamado")
        Toast.makeText(this, "onStart chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        // Mensagem de log e Toast para onResume
        Log.d("LifecycleDemo", "onResume chamado")
        Toast.makeText(this, "onResume chamado", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()

        // Mensagem de log e Toast para onPause
        Log.d("LifecycleDemo", "onPause chamado")
        Toast.makeText(this, "onPause chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        // Mensagem de log e Toast para onStop
        Log.d("LifecycleDemo", "onStop chamado(no logs)")
        Toast.makeText(this, "onStop chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("LifecycleDemo", "onDestroy chamado(no logs)")
        super.onDestroy()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifyCycleActivityTheme {
        Greeting("Android")
    }
}