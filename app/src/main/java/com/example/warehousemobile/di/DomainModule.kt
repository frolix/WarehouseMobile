package com.example.warehousemobile.di

import com.example.domain.usecase.RoomUseCase
import com.example.domain.usecase.RoomUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    internal abstract fun bindUseCase(roomUseCaseImpl:RoomUseCaseImpl):RoomUseCase

}
