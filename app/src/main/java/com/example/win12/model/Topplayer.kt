package com.example.win12.model


import com.google.gson.annotations.SerializedName

data class Topplayer(
    @SerializedName("age")
    val age: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("winloss")
    val winloss: String
)