package com.example.win12.model


import com.google.gson.annotations.SerializedName

data class TipsModel(
    @SerializedName("tabletennistips")
    val tabletennistips: List<Tabletennistip>
)