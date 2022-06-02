package com.binar.jetpackcomposelist

import com.binar.jetpackcomposelist.api.ApiService
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import com.binar.jetpackcomposelist.data.ResponseStafItem
import javax.inject.Inject

class StafRepository  @Inject constructor(private val stafapi : ApiService) {

    suspend fun getStaf(): List<ResponseStafItem>{
        return stafapi.getAllStaf()
    }
}