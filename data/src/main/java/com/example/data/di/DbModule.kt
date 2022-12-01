package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.model.accounts.AccountsDao
import com.example.data.model.documents.DocumentsDao
import com.example.data.model.productAndSerial.ProductAndSerialsDao
import com.example.data.model.productAndSerial.products.ProductDao
import com.example.data.model.productAndSerial.serials.SerialDao
import com.example.data.model.typeDocument.TypeOfDocumentDao
import com.example.data.model.warehouse.WarehouseDao
import com.example.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideAccountsDao(appDatabase: AppDatabase): AccountsDao {
        return appDatabase.getAccountsDao()//accountsDao: AccountsDao
    }

    @Singleton
    @Provides
    fun provideDocumentsDao(appDatabase: AppDatabase): DocumentsDao {
        return appDatabase.getDocumentsDao()//accountsDao: AccountsDao
    }


    @Singleton
    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.getProductDao()//accountsDao: AccountsDao
    }

    @Singleton
    @Provides
    fun provideSerialDao(appDatabase: AppDatabase): SerialDao {
        return appDatabase.getSerialDao()//accountsDao: AccountsDao
    }

    @Singleton
    @Provides
    fun provideProductAndSerialsDao(appDatabase: AppDatabase): ProductAndSerialsDao {
        return appDatabase.getProductAndSerialsDao()//accountsDao: AccountsDao
    }


    @Singleton
    @Provides
    fun provideTypeOfDocumentDao(appDatabase: AppDatabase): TypeOfDocumentDao {
        return appDatabase.getTypeOfDocumentDao()//accountsDao: AccountsDao
    }

    @Singleton
    @Provides
    fun provideWarehouseDao(appDatabase: AppDatabase): WarehouseDao {
        return appDatabase.getWarehouseDao()//accountsDao: AccountsDao
    }


}