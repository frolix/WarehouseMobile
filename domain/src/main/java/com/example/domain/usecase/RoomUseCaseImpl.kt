package com.example.domain.usecase

import com.example.domain.entity.*
import com.example.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomUseCaseImpl @Inject constructor(private val roomRepository: RoomRepository) :
    RoomUseCase {

    override suspend fun insertDocument(document: Document) {
        roomRepository.insertDocument(document)
    }

    override suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    ) {
        roomRepository.insertDocWarehouseType(document, warehouse, typeOfDocument)
    }

    override suspend fun getDocumentWarehouseType(): Flow<List<DocumentWarehouseType>> {
        return roomRepository.getDocumentWarehouseType()
    }

    override suspend fun getDocumentWithProduct(): Flow<List<DocumentProdAndSerial>> {
        return roomRepository.getDocumentWithProduct()
    }

    override suspend fun getDocumentWithProductById(documentId: Long): Flow<DocumentProdAndSerial?> {
        return roomRepository.getDocumentWithProductById(documentId)
    }

    override suspend fun getDocumentById(documentId: Long): Flow<DocumentWarehouseType?> {
        return getDocumentById(documentId)
    }


    override suspend fun insertProduct(documentId: Long, product: List<Product>) {
        roomRepository.insertProduct(documentId, product)
    }

    override suspend fun insertSerial(serial: List<Serial>, documentId: Long) {
        roomRepository.insertSerial(serial, documentId)
    }

    override suspend fun insertProductAndSerial(
        product: Product,
        serial: List<Serial>,
        documentId: Long
    ) {
        roomRepository.insertProductAndSerial(product, serial, documentId)
    }

    override suspend fun getProductsWithSerial(documentId: Long): Flow<List<ProductAndSerial>> {
        return roomRepository.getProductsWithSerial(documentId)
    }

    override suspend fun insertTypeOfDocument(typeOfDocument: TypeOfDocument) {
        roomRepository.insertTypeOfDocument(typeOfDocument)
    }

    override suspend fun getTypeOfDocById(typeId: Long): Flow<TypeOfDocument?> {
        return roomRepository.getTypeOfDocById(typeId)
    }

    override suspend fun getTypeOfDocByKey(typeKey: String): Flow<List<TypeOfDocument>?> {
        return roomRepository.getTypeOfDocByKey(typeKey)
    }

    override suspend fun insertWarehouse(warehouse: Warehouse) {
        roomRepository.insertWarehouse(warehouse)
    }

    override suspend fun getWarehouseById(warehouseId: Long): Flow<Warehouse?> {
        return roomRepository.getWarehouseById(warehouseId)
    }

    override suspend fun getWarehouseByKey(warehouseKey: String): Flow<List<Warehouse>?> {
        return roomRepository.getWarehouseByKey(warehouseKey)
    }


}