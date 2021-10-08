package com.example.simpledaggerhilt.api

import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.data.login.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface KnotKoqService {

    @POST("WEB/LOGIN")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>

}