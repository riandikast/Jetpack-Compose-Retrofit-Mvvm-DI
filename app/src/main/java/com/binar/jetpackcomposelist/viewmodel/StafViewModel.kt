package com.binar.jetpackcomposelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.jetpackcomposelist.NewsRepository
import com.binar.jetpackcomposelist.StafRepository
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import com.binar.jetpackcomposelist.data.ResponseStafItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StafViewModel @Inject constructor(private val api: StafRepository): ViewModel() {
    private val stafState = MutableStateFlow(emptyList<ResponseStafItem>())
    val dataState : StateFlow<List<ResponseStafItem>>
        get() = stafState

    init {
        viewModelScope.launch {
            val staf = api.getStaf()
            stafState.value = staf
        }
    }
}