package com.example.win12.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win12.model.TopPlayersModel
import com.example.win12.repository.TopPlayersRepository
import kotlinx.coroutines.launch

class TopPlayersViewModel(private val topPlayersRepository: TopPlayersRepository): ViewModel() {
    init {
        viewModelScope.launch {
            topPlayersRepository.getTopPlayers()
        }
    }
    val topPlayers: LiveData<TopPlayersModel>
    get() = topPlayersRepository.topPlayers
}