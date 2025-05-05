package com.example.moviemanager.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviemanager.database.MovieDatabase
import com.example.moviemanager.ui.theme.theme.MoviemanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get database instance
        val database = MovieDatabase.getDatabase(applicationContext)
        val movieDao = database.movieDao()

        setContent {
            MoviemanagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(this)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Movie Manager",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Add Movies to DB Button
        Button(
            onClick = {
                val intent = Intent(activity, SearchMovieActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Add Movies to DB")
        }

        // Search for Movies Button
        Button(
            onClick = {
                val intent = Intent(activity, SearchMovieActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Search for Movies")
        }

        // Search for Actors Button
        Button(
            onClick = {
                val intent = Intent(activity, SearchActorActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Search for Actors")
        }
    }
}