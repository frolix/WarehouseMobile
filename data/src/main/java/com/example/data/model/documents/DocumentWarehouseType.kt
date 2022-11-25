package com.example.data.model.documents

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity

data class DocumentWarehouseType(
    @Embedded val documentEntity: DocumentEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "ownerId"
    ) val warehouseEntity: WarehouseEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "ownerId"
    ) val typeOfDocumentEntity: TypeOfDocumentEntity
)
