package com.example.simpledaggerhilt.api

import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.data.login.dto.LoginRequest
import com.example.simpledaggerhilt.data.login.dto.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface LoginService {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("web/login")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<LoginResponse>

}