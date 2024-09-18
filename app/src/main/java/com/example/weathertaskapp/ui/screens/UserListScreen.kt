package com.example.weathertaskapp.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
//import com.example.weatherapp.viewmodel.UserListViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weathertaskapp.viewmodel.UserListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(navController: NavController, userListViewModel: UserListViewModel = viewModel()) {


    val userList by userListViewModel.userList.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User List") },
                actions = {
                    IconButton(onClick = { navController.navigate("user_form_screen"){

                       //     popUpTo("user_list_screen") { inclusive = true }

                    } }) {
                        Icon(Icons.Default.Add, contentDescription = "Add User")
                    }
                }
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxSize()
        ) {


            items(userList) { user ->

                Log.e("user",user.email)
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {

                    Column(modifier = Modifier.weight(1f))
                    {
                        Text(text = "${user.firstName} ${user.lastName}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("weather_screen")
                                })
                        Text(
                            text = user.email,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                    }
                    IconButton(onClick = { userListViewModel.deleteUser(user) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            }
        }
    }
}
