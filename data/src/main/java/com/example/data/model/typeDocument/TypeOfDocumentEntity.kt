package com.example.data.model.typeDocument

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.TypeOfDocument

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
    @ColumnInfo(name = "owner_id") var ownerId: Long,
    @ColumnInfo(name = "description") val description: String,
) {
    fun toTypeOfDocument(): TypeOfDocument = TypeOfDocument(
        id = id,
        docTypeKey = docTypeKey,
        ownerId = ownerId,
        description = description,
    )

    companion object {
        fun fromTypeToEntity(typeOfDocument: TypeOfDocument) = TypeOfDocumentEntity(
            id = 0, // SQLite generates identifier automatically if ID = 0
            docTypeKey = typeOfDocument.docTypeKey,
            ownerId = typeOfDocument.ownerId,
            description = typeOfDocument.description,
        )
    }
}
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