package com.example.data.model.typeDocument

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "type_of_document",
//    foreignKeys = [
////        ForeignKey(
////            entity = DocumentEntity::class,
////            parentColumns = ["documentType"],
////            childColumns = ["document_type_key"],
////            onDelete = ForeignKey.NO_ACTION,
////            onUpdate = ForeignKey.CASCADE
////        ),
////        ForeignKey(
////            entity = ProductEntity::class,
////            parentColumns = ["key"],
////            childColumns = ["document_key_string"],
////            onDelete = ForeignKey.CASCADE,
////            onUpdate = ForeignKey.CASCADE
////        ),
//    ]

)
data class TypeOfDocumentEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "document_type_key") val docTypeKey: String,
    @ColumnInfo(name = "owner_id") val ownerId: Long,
    @ColumnInfo(name = "description") val description: Long,
)
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