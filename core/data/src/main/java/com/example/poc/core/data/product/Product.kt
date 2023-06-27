package com.example.poc.core.data.product

data class Product(
    val id: Long? = null,
    val title: String = "",
    val drawableId: Int = com.example.poc.core.ui.R.drawable.ic_fastfood,
    val description: String = ""
)