package com.example.domain.usecase

import com.example.domain.entity.Document
import com.example.domain.entity.TypeOfDocument
import com.example.domain.entity.Warehouse

interface RoomUseCase {

    suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    )


}