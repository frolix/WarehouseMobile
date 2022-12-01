package com.example.data.model.documents

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.model.productAndSerial.ProductAndSerialById
import com.example.data.model.productAndSerial.products.ProductEntity

data class DocumentProdAndSerialTuple(
    @Embedded val documentEntity: DocumentEntity,
    @Relation(
        entity = ProductEntity::class,
        parentColumn = "id",
        entityColumn = "document_key"
    ) val prodAndSerial: List<ProductAndSerialById>,
)
