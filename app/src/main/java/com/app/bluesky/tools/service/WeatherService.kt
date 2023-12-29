package com.app.bluesky.tools.service

import com.app.bluesky.tools.api.dto.pollution.PollutionResponse
import com.app.bluesky.tools.api.dto.weather.WeatherResponse
import com.app.bluesky.tools.api.invoker.OpenWeatherMapService
import com.app.bluesky.tools.api.invoker.getClient

class WeatherService(val apiKey: String?) {
    private val APPID = "appid"
    private val UNITS = "units"
    private val LANGUAGE = "lang"
    private val QUERY = "q"
    private val CITY_ID = "id"
    private val LATITUDE = "lat"
    private val LONGITUDE = "lon"
    private val ZIP_CODE = "zip"
    private val openWeatherMapService: OpenWeatherMapService =
        getClient()!!.create(OpenWeatherMapService::class.java)

    suspend fun getCurrentWeatherByCityID(lon: String, lat: String): WeatherResponse? {
        return try {
            val options: MutableMap<String?, String?> = HashMap()
            options[UNITS] = "metric"
            options[LANGUAGE] = "en"
            options["lat"] = lat
            options["lon"] = lon
            options[APPID] = apiKey
            openWeatherMapService.getCurrentWeatherByLocation(options)
        } catch (e: Throwable) {
            null
        }
    }

    suspend fun getCurrentPollutionByCityID(lon: String, lat: String): PollutionResponse {
        val options: MutableMap<String?, String?> = HashMap()
        options["lat"] = lat
        options["lon"] = lon
        options[APPID] = apiKey
        return openWeatherMapService.getCurrentPollutionByLocation(options)
    }

}