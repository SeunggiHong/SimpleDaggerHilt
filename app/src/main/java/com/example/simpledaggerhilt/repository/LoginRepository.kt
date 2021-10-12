package com.example.simpledaggerhilt.repository

import com.example.simpledaggerhilt.api.LoginService
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.data.login.dto.LoginResponse
import com.example.simpledaggerhilt.data.login.remote.LoginRemoteDataSource
import com.example.simpledaggerhilt.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository {

    suspend fun login(loginRequest: LoginRequest): Flow<BaseResource<LoginResponse>> {
        return flow {
            emit(BaseResource.loading())
            emit(loginRemoteDataSource.login(loginRequest))
        }.flowOn(ioDispatcher)

    }

}