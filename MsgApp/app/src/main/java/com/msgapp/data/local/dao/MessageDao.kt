package com.msgapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.msgapp.model.Message
import kotlinx.coroutines.flow.Flow


@Dao
interface MessageDao {

    @Query("SELECT * FROM messages ORDER BY timestamp ASC")
    fun getAllMessages(): Flow<List<Message>>


    @Insert
    suspend fun insertMessage(message: Message)
}