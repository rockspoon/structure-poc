package com.example.poc.settings.domain

import com.example.poc.core.data.credentials.CredentialsRepository

class LogoutUserUseCase(private val credentialsRepository: CredentialsRepository) {

    suspend operator fun invoke() {
        credentialsRepository.logout()
    }
}