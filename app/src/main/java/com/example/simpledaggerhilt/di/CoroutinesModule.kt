package com.example.simpledaggerhilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
internal object CoroutinesModule {

//    @Provides
//    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

//    @Provides
//    fun providersMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

//    @Provides
//    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

}
