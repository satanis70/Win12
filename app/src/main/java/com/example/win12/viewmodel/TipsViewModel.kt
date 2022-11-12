package com.example.win12.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win12.model.TipsModel
import com.example.win12.repository.TipsRepository
import kotlinx.coroutines.launch

class TipsViewModel(private val tipsRepository: TipsRepository): ViewModel() {
    init {
        viewModelScope.launch {
            tipsRepository.getTips()
        }
    }
    val tips: LiveData<TipsModel>
    get() = tipsRepository.tips
}