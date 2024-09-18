package com.example.weathertaskapp.ui.naviagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.weathertaskapp.ui.screens.LoginScreen
//import com.example.weatherapp.ui.screens.LoginScreen
//import com.example.weatherapp.ui.screens.OnboardingScreen
//import com.example.weatherapp.ui.screens.UserFormScreen
//import com.example.weatherapp.ui.screens.UserListScreen
//import com.example.weatherapp.ui.screens.WeatherScreen
import com.example.weathertaskapp.ui.screens.OnboardingScreen
import com.example.weathertaskapp.ui.screens.UserFormScreen
import com.example.weathertaskapp.ui.screens.UserListScreen
import com.example.weathertaskapp.ui.screens.WeatherScreen
import com.example.weathertaskapp.utils.DataStoreManager

@Composable
fun WeatherAppNavHost(navController: NavHostController,dataStoreManager: DataStoreManager) {
    NavHost(navController, startDestination = "onboarding_screen") {
        composable("onboarding_screen") { OnboardingScreen(navController,dataStoreManager) }
        composable("login_screen") { LoginScreen(navController, dataStoreManager = dataStoreManager) }
        composable("user_list_screen") { UserListScreen(navController) }
        composable("user_form_screen") { UserFormScreen(navController) }
        composable("weather_screen") { WeatherScreen(navController,dataStoreManager) }
    }
}
