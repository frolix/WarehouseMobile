package com.example.data.model.productAndSerial.serials

import androidx.room.*

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
//    @Relation()
    @ColumnInfo(name = "document_key") val documentKey: Long,// foreign key
    @ColumnInfo(name = "document_key_string") val documentKeyString: String,// foreign key
    @ColumnInfo(name = "owner_key") val ownerKey: String,
    @ColumnInfo(name = "owner_id") val ownerId: Long,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "serialNumber") val serialNumber: String,
)
