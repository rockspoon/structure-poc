package com.example.poc.settings.domain

import com.example.poc.core.domain.base.UseCase
import com.example.poc.core.data.preferences.PreferencesDataSource
import kotlinx.coroutines.CoroutineDispatcher

// I am using PreferenceDataSource directly since there is only one type of PreferenceDataSource
// implementation and there is no need to extra logic that would be in repository, like the sync
// implementation in the UserRepository.
class UpdateIsNotificationEnabledUseCase(
    private val preferencesDataSource: PreferencesDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<Boolean, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Boolean) {
        preferencesDataSource.setIsNotificationEnabled(parameters)
    }
}