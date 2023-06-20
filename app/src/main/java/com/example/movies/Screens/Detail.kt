package com.example.movies.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movies.Data.List_Movies

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Detail(navController: NavController, movieId: Int){
    val movie=List_Movies()
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = movie.listMovies[movieId].title,textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }) {
        Detail_Screen(navController,movieId,movie)
    }
}

@Composable
fun Detail_Screen(navController: NavController,movieId: Int, movie: List_Movies){
Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.size(30.dp))
    AsyncImage(model = movie.listMovies[movieId].image, contentDescription ="Portada",
        modifier=Modifier.size(350.dp))
    Spacer(modifier = Modifier.size(10.dp))
    Text(text = "Descripcion",textAlign= TextAlign.Left, textDecoration = TextDecoration.Underline,)
    Spacer(modifier = Modifier.size(10.dp))
    Text(text = movie.listMovies[movieId].description,textAlign= TextAlign.Justify,
        modifier = Modifier
            .fillMaxWidth()
            .width(30.dp)
            .padding(top = 10.dp, end = 50.dp, start = 50.dp))
}
}
