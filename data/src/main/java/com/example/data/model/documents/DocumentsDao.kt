package com.example.data.model.documents

import androidx.room.*
import com.example.data.model.typeDocument.TypeOfDocumentEntity
import com.example.data.model.warehouse.WarehouseEntity

//todo #DocumentsDao need realise
@Dao
interface DocumentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocument(vararg document: DocumentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocWarehouseType(
        document: DocumentEntity,
        warehouseEntity: WarehouseEntity,
        typeOfDocumentEntity: TypeOfDocumentEntity
    )

    @Transaction
    @Query("SELECT * FROM document_list")
    fun getDocumentWarehouseType(): List<DocumentWarehouseType>

    @Transaction
    @Query("SELECT * FROM document_list")
    fun getDocumentWithProduct(): List<DocumentProdAndSerial>

    @Transaction
    @Query("SELECT * FROM document_list WHERE document_list.id = :documentId ")
    fun getDocumentWithProductById(documentId: Long): DocumentProdAndSerial

    @Transaction
    @Query("SELECT * FROM document_list WHERE document_list.id = :documentId ")
    fun getDocumentById(documentId: Long): DocumentWarehouseType


}