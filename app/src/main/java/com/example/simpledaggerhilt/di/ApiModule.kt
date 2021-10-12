package com.example.simpledaggerhilt.di

import com.example.simpledaggerhilt.api.FolderService
import com.example.simpledaggerhilt.api.GrabService
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
object ApiModule {

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginService {
        Timber.d("ApiModule provideLoginService")
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideFolderService(retrofit: Retrofit): FolderService {
        Timber.d("ApiModule provideFolderService")
        return retrofit.create(FolderService::class.java)
    }

    @Singleton
    @Provides
    fun provideGrabService(retrofit: Retrofit): GrabService {
        Timber.d("ApiModule provideGrabService")
        return retrofit.create(GrabService::class.java)
    }

}
