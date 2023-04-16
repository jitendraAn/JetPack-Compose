package com.example.jetpackcomposetutorialapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetutorialapp.ui.screens.CreateLoginScreens
import com.example.jetpackcomposetutorialapp.ui.screens.MainScreen
import com.example.jetpackcomposetutorialapp.ui.screens.MainViewModel
import com.example.jetpackcomposetutorialapp.ui.screens.SecondScreen
import com.example.jetpackcomposetutorialapp.util.NavigationScreen

@Composable
fun StartNavigation(mainViewModel: MainViewModel) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.LoginScreen.route ){

        composable(NavigationScreen.LoginScreen.route){
            CreateLoginScreens(navController)
        }
        composable(NavigationScreen.MainScreen.route){
            MainScreen(navController)
        }
        composable(NavigationScreen.SecondScreen.route){
            SecondScreen(navController,mainViewModel)
        }
    }
}