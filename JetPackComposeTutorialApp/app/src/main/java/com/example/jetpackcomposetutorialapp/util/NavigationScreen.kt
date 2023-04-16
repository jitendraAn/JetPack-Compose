package com.example.jetpackcomposetutorialapp.util

sealed class NavigationScreen(val route:String){
    object MainScreen: NavigationScreen("MainScreen")
    object LoginScreen: NavigationScreen("LoginScreen")
    object SecondScreen: NavigationScreen("SecondScreen")
}