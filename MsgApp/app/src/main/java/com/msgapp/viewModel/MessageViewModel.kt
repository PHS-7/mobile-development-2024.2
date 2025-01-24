package com.msgapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msgapp.model.Message
import com.msgapp.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository) : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val message: StateFlow<List<Message>> = _messages.asStateFlow()

    init {
        viewModelScope.launch {
            // o repositório coleta as mensagens e faz isso de forma reativa/ atualização automática
            repository.allMessages.collect{ _messages.value = it }
        }
    }

    fun addMessage(content: String){
        viewModelScope.launch {
            val newMessage = Message(content = content, timestamp = System.currentTimeMillis())
            _messages.value += newMessage
            repository.addMessage(content)
        }
    }

}