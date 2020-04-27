package com.example.savingusersdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.example.savingusersdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout=binding.drawerLayout

        val navController=this.findNavController(R.id.fragment4)
       // val appBarConfiguration= AppBarConfiguration(navController.graph,drawerLayout)
       NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        
        NavigationUI.setupWithNavController(binding.navView,navController)
       navController.addOnDestinationChangedListener { controller, destination, arguments ->
           if (destination.id==controller.graph.startDestination){
              drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
           }
           else
               drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
       }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.fragment4)
        return NavigationUI.navigateUp(navController,drawerLayout) ||super.onSupportNavigateUp()
    }
}
