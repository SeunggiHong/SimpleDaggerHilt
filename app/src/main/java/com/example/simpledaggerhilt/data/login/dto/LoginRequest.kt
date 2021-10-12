package com.example.simpledaggerhilt.data.login.dto

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @field:SerializedName("id") val id: String,
    @field:SerializedName("password") val password: String,
    @field:SerializedName("device") val device: String
)