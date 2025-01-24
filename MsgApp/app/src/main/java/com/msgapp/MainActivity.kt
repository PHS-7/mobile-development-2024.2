package com.msgapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.msgapp.data.local.database.AppDataBase
import com.msgapp.repository.MessageRepository
import com.msgapp.ui.theme.MsgAppTheme
import com.msgapp.ui.view.MessageApp
import com.msgapp.viewModel.MessageViewModel
import com.msgapp.viewModel.MessageViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "messages-db"
        ).fallbackToDestructiveMigrationFrom().build()

        val repository = MessageRepository(db.messageDao())
        enableEdgeToEdge()
        setContent {
            MsgAppTheme {
                val viewModel: MessageViewModel = viewModel(factory = MessageViewModelFactory(repository))
                MessageApp(viewModel)
            }
        }
    }
}
