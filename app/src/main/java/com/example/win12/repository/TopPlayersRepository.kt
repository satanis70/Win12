package com.example.win12.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win12.model.TopPlayersModel
import com.example.win12.service.Api

class TopPlayersRepository(val api: Api) {
    private val topPlayersLiveData = MutableLiveData<TopPlayersModel>()
    val topPlayers: LiveData<TopPlayersModel>
    get() = topPlayersLiveData

    suspend fun getTopPlayers(){
        val result = api.getPlayers()
        if (result.body()!=null){
            topPlayersLiveData.postValue(result.body())
        }
    }
}