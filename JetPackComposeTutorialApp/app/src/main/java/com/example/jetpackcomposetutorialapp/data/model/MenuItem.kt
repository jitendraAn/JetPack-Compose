package com.example.jetpackcomposetutorialapp.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val discription: String,
    val icon: ImageVector
)