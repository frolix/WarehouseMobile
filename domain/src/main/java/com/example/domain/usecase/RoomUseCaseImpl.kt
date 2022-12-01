package com.example.domain.usecase

import com.example.domain.entity.Document
import com.example.domain.entity.TypeOfDocument
import com.example.domain.entity.Warehouse
import com.example.domain.repository.RoomRepository
import javax.inject.Inject

class RoomUseCaseImpl @Inject constructor(private val roomRepository: RoomRepository) :
    RoomUseCase {

    override suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    ) {
        roomRepository.insertDocWarehouseType(document, warehouse, typeOfDocument)
    }


}