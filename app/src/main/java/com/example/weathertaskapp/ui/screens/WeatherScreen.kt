package com.example.weathertaskapp.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import com.example.weathertaskapp.utils.DataStoreManager
import com.example.weathertaskapp.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherScreen(navController: NavController,dataStoreManager: DataStoreManager,weatherViewModel: WeatherViewModel = viewModel()) {

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        Log.e("WeatherScreen", "Fetching weather data")
        val latitude = "12.9082847623315"
        val longitude = "77.65197822993314"
        weatherViewModel.fetchWeather(latitude, longitude)
    }
    val weatherData by weatherViewModel.weatherData.collectAsState()
   // Log.e("WeatherScreen", "Weather Data: $weatherData")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weather") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        scope.launch {
                            dataStoreManager.saveLoginState(false)  // Clear login state

                        }

                        navController.navigate("login_screen") {

                            popUpTo("weather_screen") { inclusive = true }
                            popUpTo("user_list_screen") { inclusive = true }
                        }


                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        }
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp)
        )  {
            if (weatherData != null) {
                Column(modifier = Modifier.padding(16.dp)
                    .align(Alignment.Center)) {

                    Text(text = "Temperature: ${weatherData!!.current.temp} °F",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                    Text(text = "Weather Type: ${weatherData!!.current.weather[0].description.capitalize()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                    Text(text = "Humidity: ${weatherData!!.current.humidity}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                    Text(text = "Wind Speed: ${weatherData!!.current.windSpeed} mph",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                }
            } else {
                Text("Loading...")
            }
        }

    }
}
