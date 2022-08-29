package com.example.poc

import com.example.poc.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class CoroutineQualifiers(override val value: QualifierValue): Qualifier {

    /**
     * Qualifier for CoroutineDispatcher for IO tasks
     */
    IO_DISPATCHER("IO_DISPATCHER")

}

val coroutineModule = module {

    single {
        Dispatchers.IO
    }

    single(CoroutineQualifiers.IO_DISPATCHER) {
        Dispatchers.IO
    }
}

val appModule = module {

    includes(coroutineModule)

    viewModel {
		MainViewModel()
	}

}



