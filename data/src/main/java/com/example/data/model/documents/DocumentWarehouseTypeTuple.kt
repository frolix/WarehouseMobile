package com.example.data.model.documents

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity

data class DocumentWarehouseTypeTuple(
    @Embedded val documentEntity: DocumentEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "owner_id"
    ) val typeOfDocumentEntity: TypeOfDocumentEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "owner_id"
    ) val warehouseEntity: WarehouseEntity?,
)
