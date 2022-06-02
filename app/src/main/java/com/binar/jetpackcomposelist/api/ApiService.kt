package com.binar.jetpackcomposelist.api

import com.binar.jetpackcomposelist.data.ResponseNewsItem
import com.binar.jetpackcomposelist.data.ResponseStafItem
import retrofit2.http.GET


interface ApiService {
    @GET("news")
    suspend fun getAllNews():List<ResponseNewsItem>
    @GET("staf")
    suspend fun getAllStaf():List<ResponseStafItem>
}