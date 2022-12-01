package com.example.data.model.productAndSerial.serials

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Serial

@Entity(
    tableName = "serial_list",
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
data class SerialEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "serial_key") val serialKey: String,
    @ColumnInfo(name = "document_id") val documentId: Long,// foreign key
    @ColumnInfo(name = "document_key_string") val documentKeyString: String,// foreign key
    @ColumnInfo(name = "owner_key") val ownerKey: String,
    @ColumnInfo(name = "owner_id") val ownerId: Long,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "serialNumber") val serialNumber: String,
) {

    fun toSerials(): Serial = Serial(
        id = id,
        serialKey = serialKey,
        documentId = documentId,
        documentKeyString = documentKeyString,
        ownerKey = ownerKey,
        ownerId = ownerId,
        description = description,
        serialNumber = serialNumber,
    )
}
