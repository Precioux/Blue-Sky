package com.app.bluesky.model

class SharedData {
    object SHARE {
        lateinit var province: Province
        lateinit var city: String
        lateinit var lon: String
        lateinit var lat:String
        var isDark: Boolean = false
    }
}