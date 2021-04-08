package com.bayu.submission1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val URL = "https://api.github.com/"

    val client = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = client.create(ApiInterface::class.java)
}