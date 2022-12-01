package com.example.data.model.typeDocument

import androidx.room.*
import com.example.data.model.warehouse.WarehouseEntity
import kotlinx.coroutines.flow.Flow

//todo #TypeOfDocumentDao need realise
@Dao
interface TypeOfDocumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTypeOfDocument(typeOfDocumentEntity: TypeOfDocumentEntity)

    @Query("SELECT * FROM type_of_document WHERE id = :typeId")
    fun getTypeOfDocById(typeId: Long): Flow<TypeOfDocumentEntity?>

    @Transaction
    @Query("SELECT * FROM type_of_document WHERE type_of_document.document_type_key = :typeKey")
    fun getTypeOfDocByKey(typeKey: String): Flow<List<TypeOfDocumentEntity>?>

}