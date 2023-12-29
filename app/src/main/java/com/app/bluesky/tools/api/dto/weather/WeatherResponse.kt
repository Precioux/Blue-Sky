package com.app.bluesky.tools.api.dto.weather

import com.google.gson.annotations.SerializedName
import kotlin.reflect.KProperty

class WeatherResponse {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): Any {
//        TODO("Not yet implemented")
        return this
    }

    @SerializedName("cod")
    val cod: String? = null

    @SerializedName("city")
    val city: City? = null

    @SerializedName("list")
    val list: MutableList<CurrentWeather>? = null
}