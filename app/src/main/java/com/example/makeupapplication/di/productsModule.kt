package com.example.makeupapplication.di

import com.example.makeupapplication.common.Common
import com.example.makeupapplication.data.api.ApiManager
import com.example.makeupapplication.data.repository.ProductsRepositoryImpl
import com.example.makeupapplication.domain.repository.products.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object productsModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Common.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiManager(retrofit: Retrofit): ApiManager {
        return retrofit.create(ApiManager::class.java)
    }


    @Provides
    @Singleton
    fun provideProductsRepository(apiService: ApiManager): ProductsRepository {
        return ProductsRepositoryImpl(apiService)
    }


}