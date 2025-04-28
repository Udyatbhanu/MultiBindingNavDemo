package com.bhanu.baliyar.multibindingsnavdemo.core.di

import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.ProductsRepository
import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository
}