package com.example.domain.repository

import com.example.domain.entity.*
import kotlinx.coroutines.flow.Flow

interface RoomRepository {

    suspend fun insertDocument(document: Document)

    suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    )

    suspend fun getDocumentWarehouseType(): Flow<List<DocumentWarehouseType>>

    suspend fun getDocumentWithProduct(): Flow<List<DocumentProdAndSerial>>

    suspend fun getDocumentWithProductById(documentId: Long): Flow<DocumentProdAndSerial?>

    suspend fun getDocumentById(documentId: Long): Flow<DocumentWarehouseType?>

    ////
    suspend fun insertProduct(documentId: Long, product: List<Product>)

    suspend fun insertSerial(serial: List<Serial>, documentId: Long)

    suspend fun insertProductAndSerial(
        product: Product, serial: List<Serial>, documentId: Long
    )

    suspend fun getProductsWithSerial(documentId: Long): Flow<List<ProductAndSerial>>

    ////
    suspend fun insertTypeOfDocument(typeOfDocument: TypeOfDocument)

    suspend fun getTypeOfDocById(typeId: Long): Flow<TypeOfDocument?>

    suspend fun getTypeOfDocByKey(typeKey: String): Flow<List<TypeOfDocument>?>

    ////
    suspend fun insertWarehouse(warehouse: Warehouse)

    suspend fun getWarehouseById(warehouseId: Long): Flow<Warehouse?>

    suspend fun getWarehouseByKey(warehouseKey: String): Flow<List<Warehouse>?>


}