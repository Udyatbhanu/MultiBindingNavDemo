package com.bhanu.baliyar.multibindingsnavdemo.data.models

data class ProductsResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)