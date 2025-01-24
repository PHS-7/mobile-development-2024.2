package com.msgapp.repository

import com.msgapp.data.local.dao.MessageDao
import com.msgapp.model.Message
import kotlinx.coroutines.flow.Flow

class MessageRepository(private val dao: MessageDao) {
    val allMessages: Flow<List<Message>> = dao.getAllMessages()
    suspend fun addMessage(content: String){
        val message = Message(content = content, timestamp = System.currentTimeMillis())
        dao.insertMessage(message)
    }

}