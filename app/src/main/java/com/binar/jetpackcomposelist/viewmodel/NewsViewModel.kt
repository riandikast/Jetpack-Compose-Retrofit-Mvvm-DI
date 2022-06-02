package com.binar.jetpackcomposelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.jetpackcomposelist.NewsRepository
import com.binar.jetpackcomposelist.api.ApiService
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val api: NewsRepository): ViewModel() {
    private val newsState = MutableStateFlow(emptyList<ResponseNewsItem>())
    val dataState : StateFlow<List<ResponseNewsItem>>
    get() = newsState

    init {
        viewModelScope.launch {
            val news = api.getNews()
            newsState.value = news
        }
    }
}