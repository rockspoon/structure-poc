package com.example.poc.core.data.credentials

import androidx.datastore.core.DataStore
import com.rockspoon.merchant.datasource.datastore.credentials.CredentialsProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CredentialsLocalDataSourceImpl(
    private val credentialsDataStore: DataStore<CredentialsProto>
) : CredentialsLocalDataSource {

    override val credentials: Flow<Credentials?> =
        credentialsDataStore.data.map { credentialsProto ->
            credentialsProto.toModel()
        }

    override suspend fun setCredentials(credentials: Credentials) {
        credentialsDataStore.updateData {
            credentials.toProto()
        }
    }

    override suspend fun deleteCredentials() {
        credentialsDataStore.updateData { credentialsProto ->
            credentialsProto.toBuilder()
                .clear()
                .build()
        }
    }

    private fun CredentialsProto.toModel() = if (accessToken.isBlank()) null
    else Credentials(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken
    )

    private fun Credentials.toProto() = CredentialsProto.newBuilder()
        .setAccessToken(this.accessToken)
        .setRefreshToken(this.refreshToken)
        .build()

}