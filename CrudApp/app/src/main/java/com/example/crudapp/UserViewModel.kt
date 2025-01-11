package com.example.crudapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository = UserRepository

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        val userDAO = AppDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDAO)
        observerUsers()
    }

    private fun observerUsers(){
        viewModelScope.launch {
            repository.getAllUsers().collectionLatest { userList ->
                _users.value = userList
            }
        }
    }

    fun addUser(user: User){
        viewModelScope.launch { repository.insertUser(user) }
    }

    fun updateUser(user: User){
        viewModelScope.launch { repository.updateUser(user) }
    }

    fun deleteUser(user: User){
        viewModelScope.launch { repository.deleteUser(user) }
    }

}