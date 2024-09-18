package com.example.weathertaskapp.ui.screens



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import com.example.weatherapp.data.local.User
//import com.example.weatherapp.viewmodel.UserFormViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Close
import com.example.weathertaskapp.data.local.UserEntity
import com.example.weathertaskapp.viewmodel.UserFormViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserFormScreen(navController: NavController, viewModel: UserFormViewModel = viewModel()) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isSaving by remember { mutableStateOf(false) }


    fun handleSave() {
        isSaving = true
        viewModel.saveUser(UserEntity(firstName = firstName, lastName = lastName, email = email)) {
            isSaving = false
            navController.navigate("user_list_screen") {

                popUpTo("user_form_screen") { inclusive = true }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User Form") },
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Close, contentDescription = "Cancel")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { handleSave() },
                    enabled = !isSaving
                ) {
                    Text("Save")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Cancel")
                }
            }
        }
    }
}
