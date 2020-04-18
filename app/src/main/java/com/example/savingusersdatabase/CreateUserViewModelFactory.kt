package com.example.savingusersdatabase

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateUserViewModelFactory(val application: Application) : ViewModelProvider.AndroidViewModelFactory(
    application
) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateUserViewModel::class.java)){
         return CreateUserViewModel(application)as T
        }
        else throw IllegalArgumentException("Mismatch assignment")
    }
}