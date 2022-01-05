package com.example.mymovieapp.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mymovieapp.model.Movie
import com.example.mymovieapp.model.getMovies
import com.example.mymovieapp.navigation.MovieScreens
import com.example.mymovieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        )
        {

            Text(text = "Movies")

        }
    },
        backgroundColor = MaterialTheme.colors.background
    ) {

        MyMainContent(navController = navController)

    }

}

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


