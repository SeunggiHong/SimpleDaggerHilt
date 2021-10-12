package com.example.simpledaggerhilt.data.login.remote

import com.example.simpledaggerhilt.api.LoginService
import com.example.simpledaggerhilt.data.BaseDataSource
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(
    private val loginService: LoginService
) : BaseDataSource() {

    suspend fun login(loginRequest: LoginRequest) = getResult {
        loginService.login(loginRequest)
    }
}