package com.example.simpledaggerhilt.api

import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.data.grab.GrabResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GrabService {

    @GET("web/memo/mine/json.do?")
    suspend fun getAllGrabs(
        @Query("action") action: String,
        @Query("keyword") keyword: String,
        @Query("start") start: Int,
        @Query("limit") limit: Int,
        @Query("category") category: Int,
        @Query("typeby") typeBy: Int,
        @Query("sortby") sortBy: Int,
        @Query("someone") someone: String,
        @Query("ccode") cCode: String,
        @Query("all") all : Int
    ) : Response<GrabResponse>

}