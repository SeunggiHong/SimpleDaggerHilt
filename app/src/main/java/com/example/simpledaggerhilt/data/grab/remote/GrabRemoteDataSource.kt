package com.example.simpledaggerhilt.data.grab.remote

import com.example.simpledaggerhilt.api.GrabService
import com.example.simpledaggerhilt.data.BaseDataSource
import javax.inject.Inject

class GrabRemoteDataSource @Inject constructor(
    private val grabService: GrabService
): BaseDataSource() {

    suspend fun fetchAllGrabs() = getResult{
        grabService.getAllGrabs("mine", "", 0,30,0,0,0,"","kr",0)
    }

}
