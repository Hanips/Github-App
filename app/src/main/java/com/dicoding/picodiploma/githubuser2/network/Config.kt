package com.dicoding.picodiploma.githubuser2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {
    private const val BASE_URL = "https://api.github.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(Api::class.java)
}