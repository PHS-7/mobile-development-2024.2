package com.example.crudapp

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDAO) {

    suspend fun insetUser(user: User) = userDAO.insertUser(user)

    fun getAllUser(): Flow<List<User>> = userDAO.getAllUsers()

    suspend fun updateUser(user: User) = userDAO.updateUser(user)

    suspend fun deleteUser(user: User) = userDAO.deleteUser(user)
}