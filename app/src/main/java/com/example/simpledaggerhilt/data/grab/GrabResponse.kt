package com.example.simpledaggerhilt.data.grab

import com.google.gson.annotations.SerializedName

data class GrabResponse(
    @SerializedName("allGrabCount") val allGrabCount: Int,
    @SerializedName("memoList") val memoList: List<Memo>
)