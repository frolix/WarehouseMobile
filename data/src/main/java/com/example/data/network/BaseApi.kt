package com.example.data.network

import com.example.domain.model.LoginResponse
import com.example.domain.model.TokenResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BaseApi {


    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("login") login: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("auth/refresh-token")
    suspend fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String?
    ): Response<TokenResponse>

    @POST("logout")
    suspend fun logout(): ResponseBody
}