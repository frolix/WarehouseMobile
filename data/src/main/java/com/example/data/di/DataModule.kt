package com.example.data.di

import android.content.Context
import com.example.data.network.BaseApi
import com.example.data.network.RemoteDataSource
import com.example.data.network.TokenAuthenticator
import com.example.data.utilData.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideBaseApi(retrofit: Retrofit): BaseApi =
        retrofit.create(BaseApi::class.java)


    @Singleton
    @Provides
    fun provideRemoteDataSource(baseApi: BaseApi) =
        RemoteDataSource(baseApi)

    @Singleton
    @Provides
    fun provideTokenAuthenticator(
        @ApplicationContext context: Context,
        remoteDataSource: RemoteDataSource
    ) = TokenAuthenticator(context, remoteDataSource)


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, tokenAuthenticator: TokenAuthenticator): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getRetrofitClient(tokenAuthenticator))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun getRetrofitClient(authenticator: Authenticator? = null): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                }.build())
            }.also { client ->
                authenticator?.let { client.authenticator(it) }
//                if (BuildConfig.DEBUG) {
//                    val logging = HttpLoggingInterceptor()
//                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                    client.addInterceptor(logging)
//                }
            }.build()
    }

}