package com.example.settings.domain

import com.example.core.domain.base.UseCase
import com.example.poc.core.data.preference.PreferenceDataSource
import com.example.poc.core.data.preference.Theme
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// I am using PreferenceDataSource directly since there is only one type of PreferenceDataSource
// implementation and there is no need to extra logic that would be in repository, like the sync
// implementation in the UserRepository.
class UpdateIsNotificationEnabledUseCase(
    private val preferenceDataSource: PreferenceDataSource,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Boolean, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Boolean) {
        preferenceDataSource.setIsNotificationEnabled(parameters)
    }
}