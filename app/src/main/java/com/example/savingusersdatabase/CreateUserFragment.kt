package com.example.savingusersdatabase


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.savingusersdatabase.databinding.FragmentCreationBinding
import com.google.android.material.snackbar.Snackbar


class CreateUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding=DataBindingUtil.inflate<FragmentCreationBinding>(inflater,R.layout.fragment_creation,container,false)
        val application= requireNotNull(this.activity).application
        val createUserViewModelFactory=CreateUserViewModelFactory(application)
        val createUserViewModel=ViewModelProvider(this,createUserViewModelFactory).get(CreateUserViewModel::class.java)
        binding.createUserViewModel=createUserViewModel
        binding.lifecycleOwner=this
        // Observing eventInsert
        createUserViewModel.eventInsert.observe(this, Observer {insertTap->
                if (insertTap){
                      val name=binding.editText.text.toString()
                      val email=binding.email.text.toString()
                      if (hasNoEmptyField(name,email)){
                          val newUser=User(name=name,email = email)
                          createUserViewModel.insertUser(newUser)

                          /* binding.editText.setText("")
                          binding.email.setText("")*/
                          Toast.makeText(application.applicationContext,"Item successfully inserted",Toast.LENGTH_SHORT).show()
                          // navigate to UserDisplayFragment
                          this.findNavController().navigate(CreateUserFragmentDirections.actionCreateUserFragmentToUserDisplayFragment())
                          createUserViewModel.onInsertcomplete()
                      }
                    else{
                          view?.let { Snackbar.make(it,"all field are required",Snackbar.LENGTH_LONG).show() }
                          createUserViewModel.onInsertcomplete()
                      }
                }

        })


        return binding.root
    }

    private fun hasNoEmptyField(name: String, email: String): Boolean {
        return name.isNotEmpty()&&email.isNotEmpty()
    }

}
