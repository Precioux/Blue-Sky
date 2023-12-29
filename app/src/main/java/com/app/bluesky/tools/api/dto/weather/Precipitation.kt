package com.app.bluesky.tools.api.dto.weather

import com.google.gson.annotations.SerializedName

open class Precipitation {
    @SerializedName("1h")
    val oneHour: Double? = null

    @SerializedName("3h")
    val threeHour: Double? = null
}