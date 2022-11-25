package com.example.data.model.productAndSerial

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.model.documents.DocumentWarehouseType
import com.example.data.model.productAndSerial.products.ProductEntity
import com.example.data.model.productAndSerial.serials.SerialEntity

interface ProductAndSerialsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(vararg productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSerial(serialEntity: SerialEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductAndSerial(
        productEntity: ProductEntity,
        serialEntity: SerialEntity
    )

    @Transaction
    @Query("SELECT * FROM document_list")
    fun getDocumentWarehouseType(): List<DocumentWarehouseType>

    @Transaction
    @Query("SELECT * FROM product_list")
    fun getProductsWithSerial(): List<ProductAndSerialById>

}