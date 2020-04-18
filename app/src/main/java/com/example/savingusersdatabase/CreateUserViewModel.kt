package com.example.savingusersdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class CreateUserViewModel(application: Application) :AndroidViewModel(application) {
    private val userDao:UserDao

    private var _eventInsert=MutableLiveData<Boolean>()
           val eventInsert:LiveData<Boolean>
               get() = _eventInsert

  private  val viewModelJob= Job()
  private  val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)
    init {
        userDao=SingleDatabase.getSingleInstance(application.applicationContext).userDao
        _eventInsert.value=false
    }

  // fun to listen when user tap insert button
    fun onInsertTap(){
      _eventInsert.value=true

    }
    fun onInsertcomplete(){
        _eventInsert.value=false
    }
    // fun insertUser
    fun insertUser(user:User){
        uiScope.launch {
            withContext(Dispatchers.IO){
                userDao.insert(user)
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}