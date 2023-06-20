package com.example.movies.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.movies.Data.List_Movies
import com.example.movies.navigation.AppScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Text(text = "Mis Peliculas Favoritas",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth())
        }
    }){
        MainContent(navController)
    }
}

@Composable
fun MainContent(navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .fillMaxWidth()) {   Spacer(modifier = Modifier.size(30.dp))
        AsyncImage(model = "https://www.designerwomen.co.uk/wp-content/uploads/2021/01/cinemas-cinepop-1024x576-780x470.jpg",
            contentScale = ContentScale.Crop,
            contentDescription ="Imagen Principal",
            modifier= Modifier
                .size(250.dp)
                .clip(CircleShape))

        Spacer(modifier = Modifier.size(30.dp))

        var peliculas=List_Movies()
        for(p in peliculas.listMovies.indices){
            var item=p
            Button(onClick = { navController.navigate(AppScreens.Detail.route+"/$item") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray ))
            {
                Text(text = "Pelicula ${p+1}", color = Color.White)
            }
            Spacer(modifier = Modifier.size(20.dp))
        }

    }
}

