package com.example.poc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import com.example.poc.R
import com.example.poc.databinding.MainActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private lateinit var binding: MainActivityBinding

//	private val viewModel: MainViewModel by viewModel()

	private lateinit var navController: NavController

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = MainActivityBinding.inflate(layoutInflater)
		setContentView(binding.root)

		navController = supportFragmentManager
			.findFragmentById(R.id.mainNavHostFragment)
			.let { it as DynamicNavHostFragment }
			.navController

		navController.navigate(R.id.featureAuthGraphId)
	}

	fun onAuthSuccess(){
		navController.navigate(R.id.mainFragment)
	}

}