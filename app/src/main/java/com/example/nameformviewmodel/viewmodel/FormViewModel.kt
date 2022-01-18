package com.example.nameformviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nameformviewmodel.view.NameData

class FormViewModel: ViewModel() {

    private var _firstName: MutableLiveData<MutableList<String>> = MutableLiveData()
    val firstName: LiveData<MutableList<String>> get() = _firstName
    var firstNames: MutableList<String> = mutableListOf()

    private var _lastName: MutableLiveData<MutableList<String>> = MutableLiveData()
    val lastName: LiveData<MutableList<String>> get() = _lastName
    var lastNames: MutableList<String> = mutableListOf()

    fun addNameToList(input: NameData){
        val newFirst: String = input.firstName
        val newLast: String = input.lastName

        firstNames.add(newFirst)
        lastNames.add(newLast)

        _firstName.value = firstNames
        _lastName.value = lastNames
    }

}