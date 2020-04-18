package com.example.savingusersdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract class SingleDatabase:RoomDatabase() {
  abstract val userDao:UserDao
    companion object{
        var singleInstance:SingleDatabase?=null
        fun getSingleInstance(context: Context):SingleDatabase{
                var instance= singleInstance
            if (instance==null){
                  synchronized(this){
                      if (instance==null){
                          instance= Room.databaseBuilder(context.applicationContext,SingleDatabase::class.java,"simple Database")
                              .fallbackToDestructiveMigration()
                              .build()
                          singleInstance=instance
                      }
                  }
            }
           return instance!!
        }
    }
}