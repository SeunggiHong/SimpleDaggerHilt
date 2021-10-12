package com.example.simpledaggerhilt.data.login.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("result") val result: String,
    @field:SerializedName("redirectUrl") val redirectUrl: String,
    @field:SerializedName("userCookie") val userCookie: List<LoginResponseItem>
)