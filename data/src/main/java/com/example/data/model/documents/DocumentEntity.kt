package com.example.data.model.documents

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Document

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
) {
    fun toDocument(): Document = Document(
        id = id,
        documentKey = documentKey,
        number = number,
        comment = comment,
        data = data
    )

    companion object {
        fun fromDocumentToEntity(document: Document) = DocumentEntity(
            id = 0, // SQLite generates identifier automatically if ID = 0
            documentKey = document.documentKey,
            number = document.number,
            comment = document.comment,
            data = document.data
        )
    }

}
