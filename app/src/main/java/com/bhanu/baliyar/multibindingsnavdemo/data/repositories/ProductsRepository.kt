package com.bhanu.baliyar.multibindingsnavdemo.data.repositories

import com.bhanu.baliyar.multibindingsnavdemo.core.ResponseWrapper
import com.bhanu.baliyar.multibindingsnavdemo.data.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProducts(): Flow<ResponseWrapper<ProductsResponse>>
}