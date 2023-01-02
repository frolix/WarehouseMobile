package com.example.data.repository

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.example.data.model.ExceptionInsert
import com.example.data.model.documents.DocumentEntity
import com.example.data.model.documents.DocumentsDao
import com.example.data.model.productAndSerial.ProductAndSerialsDao
import com.example.data.model.productAndSerial.products.ProductEntity
import com.example.data.model.productAndSerial.serials.SerialEntity
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
//    val accountsDao: AccountsDao,
//    val productDao: ProductDao,
    val documentsDao: DocumentsDao,
//    val serialDao: SerialDao,
    val productAndSerialsDao: ProductAndSerialsDao,
    val typeOfDocumentDao: TypeOfDocumentDao,
    val warehouseDao: WarehouseDao
) : RoomRepository {
    private val TAG = "RoomRepositoryImpl"

    override suspend fun insertDocument(document: Document) {
        val entity = DocumentEntity.fromDocumentToEntity(document)
        var insert = documentsDao.insertDocument(entity)


        if (insert != null) {
            Log.d(TAG, "insertDocument: ")
        }
    }

    override suspend fun insertDocWarehouseType(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    ) {
        try {
            val entityDocument = DocumentEntity.fromDocumentToEntity(document)
//            Log.d(TAG, "insertDocWarehouseType:entityDocument $entityDocument")
//            val entity = DocumentEntity.fromDocumentToEntity(document)
            var insert = documentsDao.insertDocument(entityDocument)
            Log.d(TAG, "insert doc id: $insert")
            insert = null
            if (insert != null) {
                val entityWarehouse = WarehouseEntity.fromWarehouseToEntity(warehouse)
//                Log.d(TAG, "insertDocWarehouseType:entityWarehouse $entityWarehouse")

                entityWarehouse.ownerId = insert
                val entityTypeOfDocument = TypeOfDocumentEntity.fromTypeToEntity(typeOfDocument)
//                Log.d(TAG, "insertDocWarehouseType:entityTypeOfDocument $entityTypeOfDocument")
                entityTypeOfDocument.ownerId = insert

                warehouseDao.insertWarehouse(entityWarehouse)
                typeOfDocumentDao.insertTypeOfDocument(entityTypeOfDocument)

            } else {
                throw ExceptionInsert()
            }
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
                        documentWarehouseTypeTuple.warehouseEntity?.toWarehouse(),
                        documentWarehouseTypeTuple.typeOfDocumentEntity?.toTypeOfDocument()
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

    override suspend fun insertProduct(documentId: Long, product: List<Product>) {
        product.forEach {
            val entity = ProductEntity.fromProductToEntity(it)
            productAndSerialsDao.insertProduct(entity)
        }
    }

    override suspend fun insertSerial(serials: List<Serial>, documentId: Long) {
        serials.forEach {
            val entity = SerialEntity.fromSerialToEntity(it)
            productAndSerialsDao.insertSerial(entity)
        }
    }

    override suspend fun insertProductAndSerial(
        product: Product,
        serial: List<Serial>,
        documentId: Long
    ) {
        var entityProduct = ProductEntity.fromProductToEntity(product)
        var serialList: List<SerialEntity> = serial.map {
            SerialEntity.fromSerialToEntity(it)
        }
        productAndSerialsDao.insertProductAndSerial(entityProduct, serialList)

    }

    override suspend fun getProductsWithSerial(documentId: Long): Flow<List<ProductAndSerial>> {
        return productAndSerialsDao.getProductAndSerials(documentId).map { prodAndSerialTuple ->
            prodAndSerialTuple.map { prodAndSerial ->
                ProductAndSerial(
                    productEntity = prodAndSerial.productEntity.toProduct(),
                    serialListEntity = prodAndSerial.serialListEntity.map {
                        it.toSerials()
                    }
                )
            }
        }
    }

    override suspend fun insertTypeOfDocument(typeOfDocument: TypeOfDocument) {
        val entity = TypeOfDocumentEntity.fromTypeToEntity(typeOfDocument)
        typeOfDocumentDao.insertTypeOfDocument(entity)
    }

    override suspend fun getTypeOfDocById(typeId: Long): Flow<TypeOfDocument?> {
        TODO("Not yet implemented")
    }

    override suspend fun getTypeOfDocByKey(typeKey: String): Flow<List<TypeOfDocument>?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWarehouse(warehouse: Warehouse) {
        var entity = WarehouseEntity.fromWarehouseToEntity(warehouse)
        warehouseDao.insertWarehouse(entity)

    }

    override suspend fun getWarehouseById(typeId: Long): Flow<Warehouse?> {
        TODO("Not yet implemented")
    }

    override suspend fun getWarehouseByKey(typeKey: String): Flow<List<Warehouse>?> {
        TODO("Not yet implemented")
    }


}