package com.example.savingusersdatabase.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.savingusersdatabase.R
import com.example.savingusersdatabase.databinding.FragmentDetailUserBinding

class DetailUserFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<FragmentDetailUserBinding>(inflater, R.layout.fragment_detail_user,container,false)
        // setting userDetailViewModelFactory and userDetailViewModel
        val application= requireNotNull(this.activity).application
        val userDetailViewModelFactory=UserDetailViewModelFactory(application)
        val userDetailViewModel by lazy {
            ViewModelProvider(this,userDetailViewModelFactory)[UserDetailViewModel::class.java]
        }
        // receiving item selected and binding it to layout
        val itemSend=DetailUserFragmentArgs.fromBundle(arguments!!).userSelected
        binding.userSelected=itemSend

        return binding.root
    }
}