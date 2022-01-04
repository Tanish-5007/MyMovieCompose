package com.example.mymovieapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Magenta,
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
    movieList: List<String> = listOf(
    "Avatar",
    "300",
    "Harry Potter",
    "Life",
    "Forrest Gump",
    "Inception",
    "50 shades of grey"
)
){
    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn{
            items(items = movieList){

                MovieRow(movie = it){ movie ->

                }

            }
        }

    }
}


@Composable
fun MovieRow(movie: String,
             onItemClick: (String) -> Unit = {}){

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {

                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Image")

            }

            Text(text = movie)

        }

    }

}