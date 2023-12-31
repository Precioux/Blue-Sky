package com.app.bluesky.tools.api.dto.weather

import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("id")
    val id: Long? = null

    @SerializedName("main")
    val main: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("icon")
    val icon: String? = null
}