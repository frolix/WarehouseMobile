package com.example.data.model.warehouse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.model.documents.DocumentEntity
import com.example.domain.entity.Warehouse

@Entity(
    tableName = "warehouse_list",
//    foreignKeys = [
//        ForeignKey(
//            entity = DocumentEntity::class,
//            parentColumns = ["id"],
//            childColumns = ["owner_id"],
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
    @ColumnInfo(name = "warehouse_key") val warehouseKey: String,
    @ColumnInfo(name = "owner_id") var ownerId: Long,
    @ColumnInfo(name = "description") val description: String,
) {
    fun toWarehouse(): Warehouse = Warehouse(
        id = id,
        warehouseKey = warehouseKey,
        ownerId = ownerId,
        description = description
    )

    companion object {
        fun fromWarehouseToEntity(warehouse: Warehouse) = WarehouseEntity(
            id = 0, // SQLite generates identifier automatically if ID = 0
            warehouseKey = warehouse.warehouseKey,
            ownerId = warehouse.ownerId,
            description = warehouse.description
        )
    }
}

