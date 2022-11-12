package com.example.win12.model


import com.google.gson.annotations.SerializedName

data class TopPlayersModel(
    @SerializedName("topplayers")
    val topplayers: List<Topplayer>
)