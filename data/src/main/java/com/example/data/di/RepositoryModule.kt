package com.example.data.di

import com.example.data.model.accounts.AccountsDao
import com.example.data.model.documents.DocumentsDao
import com.example.data.model.productAndSerial.ProductAndSerialsDao
import com.example.data.model.productAndSerial.products.ProductDao
import com.example.data.model.productAndSerial.serials.SerialDao
import com.example.data.model.typeDocument.TypeOfDocumentDao
import com.example.data.model.warehouse.WarehouseDao
import com.example.data.repository.RoomRepositoryImpl
import com.example.domain.repository.RoomRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideRoomRepository(
//        accountsDao: AccountsDao,
//        productDao: ProductDao,
//        documentsDao: DocumentsDao,
//        serialDao: SerialDao,
//        productAndSerialsDao: ProductAndSerialsDao,
//        typeOfDocumentDao: TypeOfDocumentDao,
//        warehouseDao: WarehouseDao
//    ): RoomRepositoryImpl {
//        return RoomRepositoryImpl(
//            accountsDao,
//            productDao,
//            documentsDao,
//            serialDao,
//            productAndSerialsDao,
//            typeOfDocumentDao,
//            warehouseDao
//        )
//    }

    @Binds
    @Singleton
    internal abstract fun bindRoomRepository(repository: RoomRepositoryImpl): RoomRepository

}