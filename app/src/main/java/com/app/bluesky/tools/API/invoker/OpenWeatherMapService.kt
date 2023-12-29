package com.app.bluesky.tools.API.invoker

import com.app.bluesky.tools.API.dto.*
import com.app.bluesky.tools.API.dto.pollution.PollutionResponse
import com.app.bluesky.tools.API.dto.weather.WeatherResponse
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