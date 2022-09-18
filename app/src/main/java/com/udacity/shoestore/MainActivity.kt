package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val navController=this.findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        appBarConfiguration= AppBarConfiguration(navController.graph)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.navHostFragment)
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }
}
