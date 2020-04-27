package com.example.savingusersdatabase.userdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserDetailViewModelFactory( val application: Application) :ViewModelProvider.AndroidViewModelFactory(
    application
) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)){
            return UserDetailViewModel(application)as T
        }
        else
            throw IllegalArgumentException("type mismatch: UserDetailViewModel required")
    }
}