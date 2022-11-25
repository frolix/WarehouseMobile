package com.example.data.model.warehouse

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//todo #WarehouseListDao need realise
@Dao
interface WarehouseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWarehouse(warehouseEntity: WarehouseEntity)

    @Query("SELECT * FROM warehouse_list WHERE id = :warehouseId")
    fun getWarehouseById(warehouseId: Long): WarehouseEntity?

    @Transaction
    @Query("SELECT * FROM warehouse_list WHERE warehouse_list.warehouse_key = :warehouseKey")
    fun getWarehouseByKey(warehouseKey: String): Flow<List<WarehouseEntity>?>

}