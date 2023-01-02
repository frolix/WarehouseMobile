package com.example.domain.entity

data class TypeOfDocument(

    val id: Long,
    val docTypeKey: String,
    val ownerId: Long,
    val description: String,
)
