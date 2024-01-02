package com.example.warehousemobile.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.example.data.model.ExceptionInsert
import com.example.domain.entity.Document
import com.example.domain.entity.DocumentWarehouseType
import com.example.domain.entity.TypeOfDocument
import com.example.domain.entity.Warehouse
import com.example.domain.usecase.RoomUseCase
import com.example.warehousemobile.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val roomUseCase: RoomUseCase, val application: Application,
) : BaseViewModel() {

//    private val _createResponse = MutableLiveData<Resource<LoginResponse>>()
//    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse


    fun createDocumentWithAll(
        document: Document,
        warehouse: Warehouse,
        typeOfDocument: TypeOfDocument
    ) {
        viewModelScope.launch {
            try {
                roomUseCase.insertDocWarehouseType(document, warehouse, typeOfDocument)
            } catch (e: ExceptionInsert) {
                Toast.makeText(application.applicationContext, "e", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val _getDocumentWarehouseType = MutableSharedFlow<List<DocumentWarehouseType>>()
    val documentListResponse = _getDocumentWarehouseType.asSharedFlow() // read-only public view

    //    fun getDocument() {
    init {
        viewModelScope.launch {
            roomUseCase.getDocumentWarehouseType().collect {
                _getDocumentWarehouseType.emit(it)
            }
        }
    }

//    suspend fun insertProductAndSerial(
//        product: Product, serial: List<Serial>, documentId: Long
//    ){
//
//    }

}