package com.example.mymovieapp.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mymovieapp.model.Movie
import com.example.mymovieapp.model.getMovies
import com.example.mymovieapp.navigation.MovieScreens
import com.example.mymovieapp.widgets.MovieRow

@ExperimentalAnimationApi
@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.White,
            elevation = 5.dp
        )
        {

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Movies",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
    },
        backgroundColor = MaterialTheme.colors.background
    ) {

        MyMainContent(navController = navController)

    }

}

@ExperimentalAnimationApi
@Composable
fun MyMainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
){
    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn{
            items(items = movieList){

                MovieRow(movie = it){ movie ->

                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }

            }
        }

    }
}


