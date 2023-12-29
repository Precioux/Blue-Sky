package com.app.bluesky.tools.api.dto.pollution

import com.google.gson.annotations.SerializedName

class PollutionResponse {

    @SerializedName("list")
    val component: List<PollutionComponent> = listOf(PollutionComponent())
}