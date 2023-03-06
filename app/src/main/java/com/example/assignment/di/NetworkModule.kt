package com.example.assignment.di

import com.example.assignment.retrofit.ColorInterface
import com.example.assignment.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit
    {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun colorApi(retrofit : Retrofit) : ColorInterface
    {
        return retrofit.create(ColorInterface :: class.java)
    }
}