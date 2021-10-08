package com.example.simpledaggerhilt.data.folder.remote

import com.example.simpledaggerhilt.api.FolderService
import com.example.simpledaggerhilt.data.BaseDataSource
import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import retrofit2.Response
import javax.inject.Inject

class FolderRemoteDataSource @Inject constructor(
    private val folderService: FolderService
): BaseDataSource() {

    suspend fun fetchFolderList() = getResult {
        folderService.getFolder("list4client", "testUser")
    }

}