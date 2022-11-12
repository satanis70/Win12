package com.example.win12.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win12.model.TipsModel
import com.example.win12.service.Api

class TipsRepository(val api: Api){
    private val tipsLiveData = MutableLiveData<TipsModel>()
    val tips: LiveData<TipsModel>
    get() = tipsLiveData

    suspend fun getTips(){
        val result = api.getTips()
        if (result.body()!=null){
            tipsLiveData.postValue(result.body())
        }
    }
}