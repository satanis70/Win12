package com.example.win12

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://49.12.202.175/win12/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}