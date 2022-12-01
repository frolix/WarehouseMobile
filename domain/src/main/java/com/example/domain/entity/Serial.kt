package com.example.domain.entity

data class Serial(
    val id: Long,
    val serialKey: String,
    val documentId: Long,// foreign key
    val documentKeyString: String,// foreign key
    val ownerKey: String,
    val ownerId: Long,
    val description: String,
    val serialNumber: String,
)