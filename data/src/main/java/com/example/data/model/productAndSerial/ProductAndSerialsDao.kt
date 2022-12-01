package com.example.data.model.productAndSerial

import androidx.room.*
import com.example.data.model.documents.DocumentWarehouseTypeTuple
import com.example.data.model.productAndSerial.products.ProductEntity
import com.example.data.model.productAndSerial.serials.SerialEntity
import kotlinx.coroutines.flow.Flow

@Dao
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
    fun getDocumentWarehouseType(): Flow<List<DocumentWarehouseTypeTuple>>

    @Transaction
    @Query("SELECT * FROM product_list")
    fun getProductsWithSerial(): Flow<List<ProductAndSerialById>>

}