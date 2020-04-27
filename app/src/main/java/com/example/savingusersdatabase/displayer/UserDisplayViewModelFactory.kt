package com.example.savingusersdatabase.displayer

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserDisplayViewModelFactory(private val application: Application) :
    ViewModelProvider.AndroidViewModelFactory(
        application
    ) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDisplayViewModel::class.java)){
            return UserDisplayViewModel(application)as T
        }else
            throw IllegalArgumentException("type mismatch: UserDisplayViewModel required")


    }
}