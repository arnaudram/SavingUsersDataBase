package com.example.savingusersdatabase

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind_user_name")
fun TextView.userName(user: User){
    text=user.name

}

@BindingAdapter("bind_user_email")
fun TextView.userEmail(user:User){
    this.text=user.email
}

@BindingAdapter("bind_user_id")
fun TextView.userId(user: User){
    text= user.id.toString()
}
@BindingAdapter("nameBind")
fun userBindName(textView: TextView, user: User){
    textView.text=user.name
}