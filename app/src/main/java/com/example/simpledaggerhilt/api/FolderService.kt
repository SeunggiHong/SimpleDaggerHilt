package com.example.simpledaggerhilt.api

import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FolderService {

    @GET("web/grab/category/json.do?")
    suspend fun getFolder(
        @Query("action") action: String,
        @Query("id") id: String
    ) : Response<FolderResponse>

}