package com.stu.paymentstestapp.di

import com.stu.paymentstestapp.network.ApiConstants
import com.stu.paymentstestapp.network.EasypayApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideEasypayApiService(retrofit: Retrofit): EasypayApiService {
        return retrofit.create(EasypayApiService::class.java)
    }

}