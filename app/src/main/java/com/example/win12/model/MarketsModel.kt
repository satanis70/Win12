package com.example.win12.model


import com.google.gson.annotations.SerializedName

data class MarketsModel(
    @SerializedName("tennismarkets")
    val tennismarkets: List<Tennismarket>
)