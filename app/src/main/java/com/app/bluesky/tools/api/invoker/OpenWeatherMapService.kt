package com.app.bluesky.tools.api.invoker

import com.app.bluesky.tools.api.dto.*
import com.app.bluesky.tools.api.dto.pollution.PollutionResponse
import com.app.bluesky.tools.api.dto.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface OpenWeatherMapService {

    @GET(FORECAST)
    suspend fun getCurrentWeatherByLocation(@QueryMap options: Map<String?, String?>?): WeatherResponse

    @GET(POLLUTION)
    suspend fun getCurrentPollutionByLocation(@QueryMap options: Map<String?, String?>?): PollutionResponse

    companion object {
        const val POLLUTION = "/data/2.5/air_pollution"
        const val FORECAST = "/data/2.5/forecast"
    }
}