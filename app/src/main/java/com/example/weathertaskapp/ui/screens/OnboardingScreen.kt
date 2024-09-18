package com.example.weathertaskapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.weathertaskapp.utils.DataStoreManager


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnboardingScreen(navController: NavController,dataStoreManager : DataStoreManager) {


    val isLoggedIn by dataStoreManager.isLoggedIn.collectAsState(initial = false)


    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            navController.navigate("user_list_screen") {

                popUpTo("onboarding_screen") { inclusive = true }
            }
        }
    }


    Scaffold(
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome to the Weather App",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold)

                Button(onClick = {
                    if (isLoggedIn) {
                        navController.navigate("user_list_screen") {
                            popUpTo("onboarding_screen") { inclusive = true }
                        }
                    } else {
                        navController.navigate("login_screen")
                    }
                }) {
                    Text("Login")
                }
            }
        }
    )
}
