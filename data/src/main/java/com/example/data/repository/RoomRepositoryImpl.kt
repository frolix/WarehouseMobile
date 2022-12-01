package com.example.data.repository

import android.database.sqlite.SQLiteConstraintException
import com.example.data.model.accounts.AccountsDao
import com.example.data.model.documents.DocumentEntity
import com.example.data.model.documents.DocumentsDao
import com.example.data.model.productAndSerial.ProductAndSerialsDao
import com.example.data.model.productAndSerial.products.ProductDao
import com.example.data.model.productAndSerial.serials.SerialDao
import com.example.data.model.typeDocument.TypeOfDocumentDao
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseDao
import com.example.data.model.warehouse.WarehouseEntity
import com.example.domain.entity.*
import com.example.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    val accountsDao: AccountsDao,
    val productDao: ProductDao,
    val documentsDao: DocumentsDao,
    val serialDao: SerialDao,
    val productAndSerialsDao: ProductAndSerialsDao,
    val typeOfDocumentDao: TypeOfDocumentDao,
    val warehouseDao: WarehouseDao

) : RoomRepository {

    override suspend fun insertDocument(document: Document) {
        val entity = DocumentEntity.fromDocumentToEntity(document)
        documentsDao.insertDocument(entity)

    }

    override suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    ) {
        try {
            val entityDocument = DocumentEntity.fromDocumentToEntity(document)
            val entityWarehouse = WarehouseEntity.fromWarehouseToEntity(warehouse)
//            entityWarehouse.ownerId = entityDocument.id
            val entityTypeOfDocument = TypeOfDocumentEntity.fromTypeToEntity(typeOfDocument)
//            entityTypeOfDocument.ownerId = entityDocument.id
            documentsDao.insertDocWarehouseType(
                entityDocument,
                entityWarehouse,
                entityTypeOfDocument
            )
        } catch (e: SQLiteConstraintException) {
            throw e
        }
    }

    override suspend fun getDocumentWarehouseType(): Flow<List<DocumentWarehouseType>> {
        return documentsDao.getDocumentWarehouseType()
            .map { documentWarehouseType ->
                documentWarehouseType.map { documentWarehouseTypeTuple ->
                    DocumentWarehouseType(
                        documentWarehouseTypeTuple.documentEntity.toDocument(),
                        documentWarehouseTypeTuple.warehouseEntity.toWarehouse(),
                        documentWarehouseTypeTuple.typeOfDocumentEntity.toTypeOfDocument()
                    )
                }
            }
    }

    override suspend fun getDocumentWithProduct(): Flow<List<DocumentProdAndSerial>> {
        return documentsDao.getDocumentWithProduct()
            .map { documentProdAndSerial ->
                documentProdAndSerial.map { documentProdAndSerialTuple ->
                    DocumentProdAndSerial(
                        document = documentProdAndSerialTuple.documentEntity.toDocument(),
                        prodAndSerial = documentProdAndSerialTuple.prodAndSerial.map { productAndSerialById ->
                            ProductAndSerial(
                                productAndSerialById.productEntity.toProduct(),
                                productAndSerialById.serialListEntity.map {
                                    it.toSerials()
                                }
                            )
                        }
                    )
                }
            }
    }


    override suspend fun getDocumentWithProductById(documentId: Long): Flow<DocumentProdAndSerial?> {
        return documentsDao.getDocumentWithProductById(documentId)
            .map { documentProdAndSerialTuple ->
                DocumentProdAndSerial(
                    document = documentProdAndSerialTuple?.documentEntity?.toDocument(),
                    prodAndSerial = documentProdAndSerialTuple?.prodAndSerial?.map { productAndSerialById ->
                        ProductAndSerial(
                            productAndSerialById.productEntity.toProduct(),
                            productAndSerialById.serialListEntity.map {
                                it.toSerials()
                            }
                        )
                    }
                )
            }
    }

    override suspend fun getDocumentById(documentId: Long): Flow<DocumentWarehouseType?> {
        return documentsDao.getDocumentById(documentId)
            .map { documentWarehouseTypeTuple ->
                DocumentWarehouseType(
                    documentWarehouseTypeTuple?.documentEntity?.toDocument(),
                    documentWarehouseTypeTuple?.warehouseEntity?.toWarehouse(),
                    documentWarehouseTypeTuple?.typeOfDocumentEntity?.toTypeOfDocument()
                )
            }
    }

    override suspend fun insertProduct(vararg product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun insertSerial(vararg serial: Serial) {
        TODO("Not yet implemented")
    }

    override suspend fun insertProductAndSerial(product: Product, serial: Serial) {
        TODO("Not yet implemented")
    }

    override suspend fun getProductsWithSerial(): Flow<List<ProductAndSerial>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTypeOfDocument(typeOfDocument: TypeOfDocument) {
        TODO("Not yet implemented")
    }

    override suspend fun getTypeOfDocById(typeId: Long): Flow<TypeOfDocument?> {
        TODO("Not yet implemented")
    }

    override suspend fun getTypeOfDocByKey(typeKey: String): Flow<List<TypeOfDocument>?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWarehouse(warehouse: Warehouse) {
        TODO("Not yet implemented")
    }

    override suspend fun getWarehouseById(typeId: Long): Flow<Warehouse?> {
        TODO("Not yet implemented")
    }

    override suspend fun getWarehouseByKey(typeKey: String): Flow<List<Warehouse>?> {
        TODO("Not yet implemented")
    }


}