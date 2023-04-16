package com.example.jetpackcomposetutorialapp.di

import com.example.jetpackcomposetutorialapp.data.remote.ApiService
import com.example.jetpackcomposetutorialapp.data.remote.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Appmodule {

    @Provides
    fun provideRetrofit(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}