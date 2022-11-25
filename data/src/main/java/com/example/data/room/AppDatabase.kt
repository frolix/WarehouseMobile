package com.example.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.accounts.AccountsEntity
import com.example.data.model.documents.DocumentEntity
import com.example.data.model.accounts.AccountsDao
import com.example.data.model.productAndSerial.products.ProductEntity
import com.example.data.model.productAndSerial.serials.SerialEntity
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity

@Database(
    version = 1,
    entities = [
        AccountsEntity::class,
        DocumentEntity::class,
        ProductEntity::class,
        TypeOfDocumentEntity::class,
        SerialEntity::class,
        WarehouseEntity::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao

//    abstract fun getBoxesDao(): BoxesDao

}