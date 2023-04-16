package com.example.jetpackcomposetutorialapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcomposetutorialapp.R
import com.example.jetpackcomposetutorialapp.ui.theme.JetPackComposeTutorialAppTheme
import com.example.jetpackcomposetutorialapp.util.NavigationScreen

@Composable
fun CreateLoginScreens(navController: NavHostController) {
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login",
            style = MaterialTheme.typography.h3.copy(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "logo"
        )

        OutlinedTextField(value = username.value, onValueChange = {
            username.value = it
        }, placeholder = { Text("Please enter username") },
            label = { Text("UserName") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        OutlinedTextField(value = password.value, onValueChange = {
            password.value = it
        }, placeholder = { Text("Please enter password") },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        OutlinedButton(onClick = {
            navController.navigate(NavigationScreen.MainScreen.route)
        }) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTutorialAppTheme {
//        CreateLoginScreens(navController = NavHostController())
    }
}