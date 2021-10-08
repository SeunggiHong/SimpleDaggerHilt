package com.example.simpledaggerhilt.repository

import com.example.simpledaggerhilt.api.KnotKoqService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val knotKoqService: KnotKoqService
) {

}