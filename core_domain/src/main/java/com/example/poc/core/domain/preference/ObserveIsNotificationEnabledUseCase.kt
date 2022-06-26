package com.example.poc.core.domain.preference

import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.data.preferences.PreferencesDataSource
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// I am using PreferenceDataSource directly since there is only one type of PreferenceDataSource
// implementation and there is no need to extra logic that would be in repository, like the sync
// implementation in the UserRepository.
class ObserveIsNotificationEnabledUseCase(
    private val preferencesDataSource: PreferencesDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(coroutineDispatcher) {

    override fun execute(parameters: Unit): Flow<UseCase.Result<Boolean>> = preferencesDataSource
        .observeIsNotificationEnabled()
        .map {
            UseCase.Result.Success(data = it)
        }
}