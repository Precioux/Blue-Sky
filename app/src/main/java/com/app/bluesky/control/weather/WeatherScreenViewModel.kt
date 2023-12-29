package com.app.bluesky.control.weather

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.bluesky.model.DayWeather
import kotlinx.coroutines.launch
import com.app.bluesky.tools.api.dto.pollution.PollutionResponse
import com.app.bluesky.tools.service.WeatherService
import com.app.bluesky.tools.api.dto.weather.WeatherResponse
import com.app.bluesky.model.SharedData

class WeatherScreenViewModel : ViewModel() {
    private val weatherService = WeatherService("ba9185ce8b3cdf67451141e760ad03cf")
    val response: MutableState<List<DayWeather>> = mutableStateOf(emptyList())

    fun getWeather() {
        viewModelScope.launch {
            val lon = SharedData.SHARE.lon
            val lat = SharedData.SHARE.lat
            val weather = weatherService.getCurrentWeatherByCityID(lon, lat)
            if (weather != null) {
                weather.list?.sortBy { it.dt }
                val days: MutableList<DayWeather> = mutableListOf()
                processDaysWeather(days, weather)
                val pollution = weatherService.getCurrentPollutionByCityID(lon, lat)
                processPollution(pollution, days)
                response.value = days
            } else {
                response.value = listOf(DayWeather("", "", "", "", error = true))
            }
        }
    }

    private fun processPollution(
        pollution: PollutionResponse,
        days: MutableList<DayWeather>
    ) {
        when (pollution.component[0].component.so2) {
            in 0.0..20.0 -> days[0].pollution = 1
            in 20.0..80.0 -> days[0].pollution = 2
            in 80.0..250.0 -> days[0].pollution = 3
            in 250.0..350.0 -> days[0].pollution = 4
            else -> days[0].pollution = 5
        }
    }

    private fun processDaysWeather(
        days: MutableList<DayWeather>,
        weather: WeatherResponse
    ) {
        days.add(
            DayWeather(
                date = weather.list?.get(0)?.dt?.replace(" ", "T"),
                temp = weather.list?.get(0)?.main?.temp,
                pod = weather.list?.get(0)?.sys?.pod,
                cityName = weather.city?.name
            )
        )
        days.add(
            DayWeather(
                date = weather.list?.get(8)?.dt?.replace(" ", "T"),
                temp = weather.list?.get(8)?.main?.temp,
                pod = weather.list?.get(8)?.sys?.pod,
                cityName = weather.city?.name
            )
        )
        days.add(
            DayWeather(
                date = weather.list?.get(16)?.dt?.replace(" ", "T"),
                temp = weather.list?.get(16)?.main?.temp,
                pod = weather.list?.get(16)?.sys?.pod,
                cityName = weather.city?.name
            )
        )
        days.add(
            DayWeather(
                date = weather.list?.get(32)?.dt?.replace(" ", "T"),
                temp = weather.list?.get(32)?.main?.temp,
                pod = weather.list?.get(32)?.sys?.pod,
                cityName = weather.city?.name
            )
        )
        days.add(
            DayWeather(
                date = weather.list?.get(39)?.dt?.replace(" ", "T"),
                temp = weather.list?.get(39)?.main?.temp,
                pod = weather.list?.get(39)?.sys?.pod,
                cityName = weather.city?.name
            )
        )
    }
}



