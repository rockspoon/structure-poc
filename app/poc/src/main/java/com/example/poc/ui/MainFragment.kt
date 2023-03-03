package com.example.poc.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.poc.R
import com.example.poc.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.main_fragment) {

	private var _binding: MainFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		_binding = MainFragmentBinding.bind(view)

		// TODO should the fragment require authentication or should the activity provide
		// 		authentication objects? The later is recommended with good practice of
		// 		dependency injection.

		val navController = childFragmentManager
			.findFragmentById(R.id.innerNavHostFragment)
			.let { it as DynamicNavHostFragment }
			.navController

		binding.bottomNavigationView.setupWithNavController(navController)
		binding.bottomNavigationView.setOnItemSelectedListener { menuItem: MenuItem ->
			// Navigate to
			navController.navigate(menuItem.itemId)
			// TODO replace this to just notify the mainViewModel and the main view model handle the
			// 		navigation.
			true
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}