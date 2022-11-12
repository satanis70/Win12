package com.example.win12.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win12.model.MarketsModel
import com.example.win12.repository.MarketsRepository
import kotlinx.coroutines.launch

class MarketsViewModel(private val marketsRepository: MarketsRepository): ViewModel(){
    init {
        viewModelScope.launch {
            marketsRepository.getMarkets()
        }
    }
    val markets: LiveData<MarketsModel>
    get() = marketsRepository.markets
}