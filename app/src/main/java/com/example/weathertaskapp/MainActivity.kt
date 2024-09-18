package com.example.weathertaskapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.weathertaskapp.data.local.UserDatabase
import com.example.weathertaskapp.ui.naviagation.WeatherAppNavHost
import com.example.weathertaskapp.ui.theme.WeatherTaskAppTheme
import com.example.weathertaskapp.utils.DataStoreManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val dataStoreManager = DataStoreManager(applicationContext)
            WeatherAppNavHost(navController = navController,dataStoreManager)
        }
    }
}

