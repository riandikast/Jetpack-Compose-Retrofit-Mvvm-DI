package com.binar.jetpackcomposelist

import com.binar.jetpackcomposelist.api.ApiService
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService) {

    suspend fun getNews(): List<ResponseNewsItem>{
        return newsapi.getAllNews()
    }
}