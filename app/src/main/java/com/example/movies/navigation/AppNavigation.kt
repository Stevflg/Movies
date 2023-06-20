package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movies.Screens.Detail
import com.example.movies.Screens.MainScreen

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable(route = AppScreens.Main.route){
            MainScreen(navController)
        }
        composable(route = AppScreens.Detail.route + "/{movieId}",
            arguments = listOf(navArgument("movieId"){type = NavType.IntType})){
            Detail(navController,it.arguments?.getInt("movieId")!!)
        }
    }
}