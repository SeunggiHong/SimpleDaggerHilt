package com.example.simpledaggerhilt.data.login

import com.example.simpledaggerhilt.data.login.LoginItem
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("result") val result: String,
    @field:SerializedName("redirectUrl") val redirectUrl: String,
    @field:SerializedName("userCookie") val userCookie: List<LoginItem>
)