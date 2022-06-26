package com.example.poc

import com.example.poc.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single {
        Dispatchers.IO
    }

    single(Qualifiers.dispatcherIO) {
        Dispatchers.IO
    }

	viewModel {
		MainViewModel()
	}
}

object Qualifiers {
    val dispatcherIO = named("DispatcherIO")
}