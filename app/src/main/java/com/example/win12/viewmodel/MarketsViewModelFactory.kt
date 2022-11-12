package com.example.win12.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win12.repository.MarketsRepository

class MarketsViewModelFactory(private val marketsRepository: MarketsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MarketsViewModel(marketsRepository) as T
    }
}