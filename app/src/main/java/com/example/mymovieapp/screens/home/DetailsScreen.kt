package com.example.mymovieapp.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mymovieapp.model.Movie
import com.example.mymovieapp.model.getMovies
import com.example.mymovieapp.widgets.MovieRow


@ExperimentalAnimationApi
@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?){

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.White,
            elevation = 5.dp
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier
                        .clickable {
                        navController.popBackStack()
                    },
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Movies",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }) {

        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                MovieRow(movie = newMovieList[0])
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalScrollableImageView(newMovieList)
            }
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {

                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Poster"
                )

            }
        }
    }
}