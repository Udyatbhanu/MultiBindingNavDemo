package com.bhanu.baliyar.multibindingsnavdemo.data.repositories

import com.bhanu.baliyar.multibindingsnavdemo.core.ResponseWrapper
import com.bhanu.baliyar.multibindingsnavdemo.core.dispatcher.DispatcherProvider
import com.bhanu.baliyar.multibindingsnavdemo.core.safeApiCall
import com.bhanu.baliyar.multibindingsnavdemo.data.api.ProductsApi
import com.bhanu.baliyar.multibindingsnavdemo.data.models.ProductsResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsApi,
    private val dispatcher: DispatcherProvider
) :
    ProductsRepository {
    override  fun getProducts(): Flow<ResponseWrapper<ProductsResponse>> {
        return safeApiCall(dispatcher.io) {
            api.getProducts()
        }
    }
}