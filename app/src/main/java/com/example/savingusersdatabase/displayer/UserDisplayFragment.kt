package com.example.savingusersdatabase.displayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.savingusersdatabase.adapter.UsersAdapter
import com.example.savingusersdatabase.R
import com.example.savingusersdatabase.adapter.UserClickListener
import com.example.savingusersdatabase.databinding.FragmentUserDisplayerBinding

class UserDisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUserDisplayerBinding>(
            inflater,
            R.layout.fragment_user_displayer,
            container,
            false
        )
        binding.lifecycleOwner = this

        // fragment application , userDisplayViewModelFactory and userDisplayViewModel
        val application= requireNotNull(this.activity).application
       val userDisplayViewModelFactory=UserDisplayViewModelFactory(application)
         val userDisplayViewModel by lazy {
             ViewModelProvider(this,userDisplayViewModelFactory).get(UserDisplayViewModel::class.java)
         }
        // binding to UsersAdapter
        val adapter=UsersAdapter(UserClickListener {
//           this.findNavController().navigate(UserDisplayFragmentDirections.actionUserDisplayFragmentToDetailUserFragment(it))
           userDisplayViewModel.onItemSelected(it)
        })
        //observing navigateToDetailFragment and navigating to DetailUserFragment
        userDisplayViewModel.navigateToDetailFragment.observe(this, Observer {
            it?.let {
                this.findNavController().navigate(UserDisplayFragmentDirections.actionUserDisplayFragmentToDetailUserFragment(it))
                userDisplayViewModel.onItemSelectedComplete()
            }
        })
        binding.recyclerViewUsers.adapter=adapter
        //observing users and passing it to the adapter
        userDisplayViewModel.users.observe(this, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }
}