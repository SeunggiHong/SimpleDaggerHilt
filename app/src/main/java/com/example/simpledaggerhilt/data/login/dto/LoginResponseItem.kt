package com.example.simpledaggerhilt.data.login.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseItem(
    val hashKey: String,
    val fullName: String,
    val id: String,
    val pic: String
)