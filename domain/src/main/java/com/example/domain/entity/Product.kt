package com.example.domain.entity

data class Product(
    val id: Long,
    val documentKey: Long,// foreign key
    val documentKeyString: String,// foreign key
    val description: String,
    val code: String,
    val productKey: String,
    val productId: Long,
    val count: Float,
    val countPlan: Float,
)

