package com.app.bluesky.tools.api.dto.weather

import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("speed")
    val speed = 0.0

    @SerializedName("deg")
    val deg = 0.0

    @SerializedName("gust")
    val gust: Double? = null
}