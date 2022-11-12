package com.example.win12.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win12.model.MarketsModel
import com.example.win12.service.Api

class MarketsRepository(val api: Api){
    private val marketsLiveData = MutableLiveData<MarketsModel>()
    val markets: LiveData<MarketsModel>
    get() = marketsLiveData

    suspend fun getMarkets(){
        val result = api.getMarkets()
        if (result.body()!=null){
            marketsLiveData.postValue(result.body())
        }
    }
}