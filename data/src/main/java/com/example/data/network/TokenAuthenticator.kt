package com.example.data.network

import android.content.Context
import com.example.data.preferences.UserPreferences
import com.example.data.utilData.Resource
import com.example.domain.model.TokenResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    context: Context,
    private val remoteDataSource: RemoteDataSource,
) : Authenticator {

    private val appContext = context.applicationContext
    private val userPreferences = UserPreferences(appContext)

    override fun authenticate(route: Route?, response: Response): Request? {
        return runBlocking {
            val tokenResponse = getUpdatedToken()
            when (tokenResponse.status) {
                Resource.Status.SUCCESS -> {
                    userPreferences.saveAccessTokens(
                        tokenResponse.data?.access_token!!,
                        tokenResponse.data.refresh_token!!
                    )
                    response.request.newBuilder()
                        .header("Authorization", "Bearer ${tokenResponse.data.access_token}")
                        .build()
                }
                else -> null
            }
        }
    }

    private suspend fun getUpdatedToken(): Resource<TokenResponse> {
        val refreshToken = userPreferences.refreshToken.first()
        return remoteDataSource.refreshToken(refreshToken)
    }

}