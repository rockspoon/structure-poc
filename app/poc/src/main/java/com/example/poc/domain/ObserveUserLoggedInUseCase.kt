package com.example.poc.domain

import com.example.poc.core.data.credentials.Credentials
import com.example.poc.core.data.credentials.CredentialsRepository
import kotlinx.coroutines.flow.Flow

class ObserveUserLoggedInUseCase(
    private val credentialsRepository: CredentialsRepository
) {

    suspend operator fun invoke(): Flow<Credentials?> =
        credentialsRepository.observeCredentials()
}