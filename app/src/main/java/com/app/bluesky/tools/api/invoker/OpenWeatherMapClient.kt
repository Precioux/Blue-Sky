package com.app.bluesky.tools.api.invoker

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://api.openweathermap.org"
private var retrofit: Retrofit? = null

fun getClient(): Retrofit? {
    if (retrofit == null) {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    return retrofit
}