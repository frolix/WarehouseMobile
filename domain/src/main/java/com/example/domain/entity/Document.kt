package com.example.domain.entity

data class Document(
    val id: Long,
    val documentKey: String,
    val number: String,
    val comment: String,
    val data: String,
)
