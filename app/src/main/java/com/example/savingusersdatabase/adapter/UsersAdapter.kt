package com.example.savingusersdatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.savingusersdatabase.R
import com.example.savingusersdatabase.User
import com.example.savingusersdatabase.databinding.UserItemViewBinding

class UsersAdapter(val clickListener: UserClickListener):ListAdapter<User,UsersAdapter.UserViewHolder>(
    UserDiffUtilCallBack
) {



    companion object UserDiffUtilCallBack: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem===newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id==newItem.id
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding=DataBindingUtil.inflate<UserItemViewBinding>(LayoutInflater.from(parent.context),
            R.layout.user_item_view,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item,clickListener)



    }
    class  UserViewHolder ( private var binding: UserItemViewBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(
                user: User,
                clickListener: UserClickListener
            ){
                binding.user=user
                binding.userClickListener=clickListener
                binding.executePendingBindings()
            }
    }
}
class UserClickListener(var itemClick:(User)->Unit){
    fun onClick(itemUser: User){
     return   itemClick(itemUser)
    }

}