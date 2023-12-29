package com.app.bluesky.model

data class DayWeather(
    val date: String?,
    val temp: String?,
    val pod: String?,
    val cityName:String?,
    var pollution: Int = 1,
    var error: Boolean = false
)