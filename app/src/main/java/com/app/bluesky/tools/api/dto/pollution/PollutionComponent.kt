package com.app.bluesky.tools.api.dto.pollution

import com.google.gson.annotations.SerializedName

class PollutionComponent {

    @SerializedName("components")
    val component: Comp = Comp()

    open class Comp {
        @SerializedName("co")
        val co: Double? = null

        @SerializedName("no")
        val no: Double? = null

        @SerializedName("no2")
        val no2: Double? = null

        @SerializedName("o3")
        val o3: Double? = null

        @SerializedName("so2")
        var so2: Double = 0.0
    }
}