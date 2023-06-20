package com.example.movies.navigation

sealed class AppScreens(val route: String){
    object Main: AppScreens("main")
    object Detail: AppScreens("detail")
}