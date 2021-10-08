package com.example.simpledaggerhilt.data.folder

import com.example.simpledaggerhilt.data.login.dto.LoginResponseItem
import com.google.gson.annotations.SerializedName

data class FolderResponse(
    @field:SerializedName("userCookie") val userCookie: List<LoginResponseItem>
)