package com.example.simpledaggerhilt.data.login

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("id") val id: String,
    @SerializedName("password") val password: String,
    @SerializedName("device") val device: String
)