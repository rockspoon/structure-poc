package com.example.poc.search.data

data class Product(
    val id: Long,
    val title: String = "",
    val drawableId: Int = com.example.poc.core.ui.R.drawable.ic_fastfood,
    val description: String = ""
)