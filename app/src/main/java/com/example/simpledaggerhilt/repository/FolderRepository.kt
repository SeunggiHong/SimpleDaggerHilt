package com.example.simpledaggerhilt.repository

import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.data.folder.remote.FolderRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FolderRepository @Inject constructor(
    private val folderRemoteDataSource: FolderRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {

    suspend fun fetchFolderList(): Flow<BaseResource<FolderResponse>?> {
        return flow {
            emit(BaseResource.loading())
            emit((folderRemoteDataSource.fetchFolderList()))
        }.flowOn(ioDispatcher)
    }

}