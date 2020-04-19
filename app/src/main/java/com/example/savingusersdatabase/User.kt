package com.example.savingusersdatabase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
 data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0 ,
    @ColumnInfo(name="name")
var name:String,
    @ColumnInfo(name="email")
var email:String) : Parcelable {
}