package com.example.simpledaggerhilt

import com.example.simpledaggerhilt.api.HttpRequestInterceptor
import com.example.simpledaggerhilt.api.KnotKoqService
import com.example.simpledaggerhilt.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
     fun provideOkHttpClient(): OkHttpClient {
         return OkHttpClient.Builder()
             .addInterceptor(HttpRequestInterceptor())
             .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideKnotKoqService(retrofit: Retrofit): KnotKoqService {
        return retrofit.create(KnotKoqService::class.java)
    }

}