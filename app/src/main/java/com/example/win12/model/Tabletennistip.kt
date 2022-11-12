package com.example.win12.model


import com.google.gson.annotations.SerializedName

data class Tabletennistip(
    @SerializedName("definition")
    val definition: String,
    @SerializedName("name")
    val name: String
)