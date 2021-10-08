package com.example.simpledaggerhilt.data.folder.dto

import com.google.gson.annotations.SerializedName

data class FolderResponse(
    @field:SerializedName("categoryList") val categoryList: List<FolderResponseItem>
)