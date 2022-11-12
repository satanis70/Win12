package com.example.win12.service

import com.example.win12.model.MarketsModel
import com.example.win12.model.TipsModel
import com.example.win12.model.TopPlayersModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("topplayers.json")
    suspend fun getPlayers(): Response<TopPlayersModel>
    @GET("tennismarkets.json")
    suspend fun getMarkets(): Response<MarketsModel>
    @GET("tabletennistips.json")
    suspend fun getTips(): Response<TipsModel>
}