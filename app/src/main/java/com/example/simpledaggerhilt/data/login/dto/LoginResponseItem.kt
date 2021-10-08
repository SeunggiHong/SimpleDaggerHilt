package com.example.simpledaggerhilt.data.login

import com.google.gson.annotations.SerializedName

data class LoginItem(
    @field:SerializedName("hashKey") val hashKey: String,
    @field:SerializedName("fullName") val fullName: String,
    @field:SerializedName("hashKey") val id: String,
    @field:SerializedName("pic") val pic: String
)