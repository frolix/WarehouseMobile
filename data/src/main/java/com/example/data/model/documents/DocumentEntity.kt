package com.example.data.model.documents

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity

@Entity(
    tableName = "document_list",
//    foreignKeys = [
//        ForeignKey(
//            entity = WarehouseEntity::class,
//            parentColumns = ["id"],
//            childColumns = ["warehouse"],
//            onDelete = ForeignKey.NO_ACTION,
//            onUpdate = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = TypeOfDocumentEntity::class,
//            parentColumns = ["id"],
//            childColumns = ["documentType"],
//            onDelete = ForeignKey.NO_ACTION,
//            onUpdate = ForeignKey.CASCADE
//        )
//    ]
)
data class DocumentEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "document_key") val documentKey: String,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "comment") val comment: String,
//    @ColumnInfo(name = "warehouse") val warehouse: Long,// foreign key++
    @ColumnInfo(name = "data") val data: String,
//    @ColumnInfo(name = "document_type") val documentType: String,// foreign key
)
