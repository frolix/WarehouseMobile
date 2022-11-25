package com.example.data.model.productAndSerial.products

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_list",
//    foreignKeys = [
//        ForeignKey(
//            entity = WarehouseEntity::class,
//            parentColumns = ["id"],
//            childColumns = ["document_key"],
//            onDelete = ForeignKey.CASCADE,
//            onUpdate = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = TypeOfDocumentEntity::class,
//            parentColumns = ["key"],
//            childColumns = ["document_key_string"],
//            onDelete = ForeignKey.CASCADE,
//            onUpdate = ForeignKey.CASCADE
//        )
//    ]
)
data class ProductEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "document_key") val documentKey: Long,// foreign key
    @ColumnInfo(name = "document_key_string") val documentKeyString: String,// foreign key
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "product_key") val productKey: String,
    @ColumnInfo(name = "product_id") val productId: Long,
    @ColumnInfo(name = "count") val count: Float,
    @ColumnInfo(name = "count_plan") val count_plan: Float,
)
