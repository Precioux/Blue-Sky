package com.app.bluesky.tools.api.dto.weather;
import com.google.gson.annotations.SerializedName


class CurrentWeather {

    @SerializedName("weather")
    val weather: List<Weather>? = null

    @SerializedName("main")
    val main: Main? = null

    @SerializedName("sys")
    val sys: Sys? = null

    @SerializedName("dt_txt")
    val dt: String? = null

}