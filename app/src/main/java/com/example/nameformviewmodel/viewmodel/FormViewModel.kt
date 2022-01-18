package com.example.nameformviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {

    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()


    fun addUser(user: User) {
        userList.add(user)

        _users.value = userList
    }
}

data class User(
    val firstName: String,
    val lastName: String
)