package com.example.data.network

import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val baseApi: BaseApi,
) : BaseDataSource() {

    suspend fun refreshToken(refreshToken: String?) =
        getResult {
            baseApi.refreshAccessToken(refreshToken)
        }


}