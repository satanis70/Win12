package com.example.win12.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win12.repository.TipsRepository

class TipsViewModelFactory(private val tipsRepository: TipsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TipsViewModel(tipsRepository) as T
    }
}