package com.bhanu.baliyar.multibindingsnavdemo.data.api

import com.bhanu.baliyar.multibindingsnavdemo.data.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10,
        @Query("skip") skip: Int = 0
    ): Response<ProductsResponse>
}