package com.app.bluesky.tools.API.dto.pollution

import com.google.gson.annotations.SerializedName

class PollutionResponse {

    @SerializedName("list")
    val component: List<PollutionComponent> = listOf(PollutionComponent())
}