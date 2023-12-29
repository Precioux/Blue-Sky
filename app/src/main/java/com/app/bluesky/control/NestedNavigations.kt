package com.app.bluesky.control


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.bluesky.model.SharedData
import com.app.bluesky.control.choose.ChooseCityScreen
import com.app.bluesky.control.choose.ChooseProvinceScreen
import com.app.bluesky.control.weather.WeatherScreen
import com.app.bluesky.control.welcome.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Routes.NavigationRoute.route,
        startDestination = NavigationRoutes.Routes.Welcome.route
    ) {
        // Welcome
        composable(route = NavigationRoutes.Routes.Welcome.route) {
            WelcomeScreen(
                onNavigateToCurrent = {
                    SharedData.SHARE.lon = "51.375994"
                    SharedData.SHARE.lat = "35.688911"
                    navController.navigate(route = NavigationRoutes.Routes.Weather.route)
                },
                onNavigateToChoose = {
                    navController.navigate(route = NavigationRoutes.Routes.ChooseProvince.route)
                },
            )
        }

        composable(
            route = NavigationRoutes.Routes.ChooseProvince.route,
        ) {
            ChooseProvinceScreen(
                onNavigateBack = { navController.navigate(route = NavigationRoutes.Routes.Welcome.route) },
                onSubmit = { navController.navigate(route = NavigationRoutes.Routes.ChooseCity.route) }
            )
        }

        composable(
            route = NavigationRoutes.Routes.ChooseCity.route,
        ) {
            ChooseCityScreen(
                onNavigateBack = { navController.navigate(route = NavigationRoutes.Routes.ChooseProvince.route) },
                onSubmit = { navController.navigate(route = NavigationRoutes.Routes.Weather.route) }
            )
        }

        composable(route = NavigationRoutes.Routes.Weather.route) {
            WeatherScreen()
        }
    }
}