package com.example.data.model.documents

import androidx.room.*
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity
import kotlinx.coroutines.flow.Flow

//todo #DocumentsDao need realise
@Dao
interface DocumentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDocument(document: DocumentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDocWarehouseType(
        document: DocumentEntity,
        warehouseEntity: WarehouseEntity,
        typeOfDocumentEntity: TypeOfDocumentEntity
    )

    @Transaction
    @Query("SELECT * FROM document_list")
    fun getDocumentWarehouseType(): Flow<List<DocumentWarehouseTypeTuple>>

    @Transaction
    @Query("SELECT * FROM document_list")
    fun getDocumentWithProduct(): Flow<List<DocumentProdAndSerialTuple>>

    @Transaction
    @Query("SELECT * FROM document_list WHERE document_list.id = :documentId ")
    fun getDocumentWithProductById(documentId: Long): Flow<DocumentProdAndSerialTuple?>

    @Transaction
    @Query("SELECT * FROM document_list WHERE document_list.id = :documentId ")
    fun getDocumentById(documentId: Long): Flow<DocumentWarehouseTypeTuple?>


}