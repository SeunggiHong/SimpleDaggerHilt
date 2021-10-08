package com.example.simpledaggerhilt.di

import com.example.simpledaggerhilt.api.LoginService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginService {
        Timber.d("LoginModule provideLoginService")
        return retrofit.create(LoginService::class.java)
    }

}
