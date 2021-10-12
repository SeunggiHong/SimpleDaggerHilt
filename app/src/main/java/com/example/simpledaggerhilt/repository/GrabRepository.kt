package com.example.simpledaggerhilt.repository

import com.example.simpledaggerhilt.data.BaseResource
import com.example.simpledaggerhilt.data.folder.dto.FolderResponse
import com.example.simpledaggerhilt.data.folder.remote.FolderRemoteDataSource
import com.example.simpledaggerhilt.data.grab.GrabResponse
import com.example.simpledaggerhilt.data.grab.remote.GrabRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GrabRepository @Inject constructor(
    private val grabRemoteDataSource: GrabRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {

    suspend fun fetchGrabAllList(): Flow<BaseResource<GrabResponse>?> {
        return flow {
            emit(BaseResource.loading())
            emit((grabRemoteDataSource.fetchAllGrabs()))
        }.flowOn(ioDispatcher)
    }

}