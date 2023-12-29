package com.app.bluesky.control
sealed class NavigationRoutes {
    sealed class Routes(val route: String) : NavigationRoutes() {
        object NavigationRoute : Routes(route = "unauthenticated")
        object Welcome : Routes(route = "welcome")
        object ChooseProvince : Routes(route = "province")
        object ChooseCity : Routes(route = "city")
        object Weather : Routes(route = "weather")
        object Current : Routes(route = "current")
    }
}