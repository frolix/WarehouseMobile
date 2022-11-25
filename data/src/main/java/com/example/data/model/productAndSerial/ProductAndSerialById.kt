package com.example.data.model.productAndSerial

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.model.productAndSerial.products.ProductEntity
import com.example.data.model.productAndSerial.serials.SerialEntity

data class ProductAndSerialById(
    @Embedded val productEntity: ProductEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "ownerId"
    ) val serialListEntity: List<SerialEntity>,
)