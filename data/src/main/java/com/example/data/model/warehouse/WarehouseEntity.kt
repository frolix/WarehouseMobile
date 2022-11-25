package com.example.data.model.warehouse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "warehouse_list",
//    foreignKeys = [
//        ForeignKey(
//            entity = DocumentEntity::class,
//            parentColumns = ["warehouse"],
//            childColumns = ["id"],
//            onDelete = ForeignKey.NO_ACTION,
//            onUpdate = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = ProductEntity::class,
//            parentColumns = ["document_key"],
//            childColumns = ["id"],
//            onDelete = ForeignKey.CASCADE,
//            onUpdate = ForeignKey.CASCADE
//        ),
//    ]
)
data class WarehouseEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "warehouse_key") val warehouseKey: Long,
    @ColumnInfo(name = "owner_key") val ownerId: Long,
    @ColumnInfo(name = "description") val description: Long,
)

