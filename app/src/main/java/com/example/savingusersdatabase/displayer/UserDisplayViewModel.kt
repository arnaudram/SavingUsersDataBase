package com.example.savingusersdatabase.displayer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.savingusersdatabase.SingleDatabase
import com.example.savingusersdatabase.User

class UserDisplayViewModel(application: Application) :AndroidViewModel(application){
    /* getting access to the userDao instance */
  private  val userDao= SingleDatabase.getSingleInstance(application.applicationContext).userDao
    // fetching all existing users
    val users=userDao.getAllUsers()
    private val _navigateToDetailFragment=MutableLiveData<User>()


    val navigateToDetailFragment:LiveData<User>
    get() = _navigateToDetailFragment

    fun onItemSelected(item:User){
        _navigateToDetailFragment.value=item
    }
    fun onItemSelectedComplete(){
        _navigateToDetailFragment.value=null
    }
}