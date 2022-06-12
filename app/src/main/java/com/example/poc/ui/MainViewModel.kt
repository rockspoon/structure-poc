package com.example.poc.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.poc.R

class MainViewModel(
	private val navController: NavController
) : ViewModel() {

	fun auth(){
		navController.navigate(R.id.innerGraphId)
	}
}