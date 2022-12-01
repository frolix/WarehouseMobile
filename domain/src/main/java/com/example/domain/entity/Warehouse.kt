package com.example.domain.entity

data class Warehouse(
    val id: Long,
    val warehouseKey: String,
    val ownerId: Long,
    val description: String,
)
