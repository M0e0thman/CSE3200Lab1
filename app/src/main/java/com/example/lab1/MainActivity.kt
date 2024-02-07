package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme
import kotlin.random.Random

const val ON_CREATE = "ON_CREATE"
const val ON_START = "ON_START"
const val ON_STOP = "ON_STOP"
const val ON_PAUSE = "ON_PAUSE"
const val ON_RESUME = "ON_RESUME"
const val ON_DESTROY = "ON_DESTROY"

class MainActivity : ComponentActivity() {
    private val jokes = listOf(
        "Why don't scientists trust atoms?\nBecause they make up everything!",
        "Why did the scarecrow win an award?\nBecause he was outstanding in his field!",
        "Parallel lines have so much in common.\nIt's a shame they'll never meet.",
        "I told my wife she should embrace her mistakes.\nShe gave me a hug.",
        "What did one hat say to the other?\nStay here, I'm going on ahead!",
        "I used to play piano by ear, but now I use my hands and fingers.",
        // Add more jokes as needed
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                MyApp(jokes)
            }
        }
        Log.i(ON_CREATE, "ONCREATE called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ON_START, "onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ON_PAUSE, "onPause called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ON_RESUME, "onResume called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ON_STOP, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ON_DESTROY, "onDestroy called")
    }
}

@Composable
fun MyApp(jokes: List<String>) {
    var currentJokeIndex by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the current joke
            Greeting(jokes[currentJokeIndex])

            // Add a button to show the next joke
            Button(
                onClick = {
                    // Increment the joke index, looping back to the first joke if necessary
                    currentJokeIndex = (currentJokeIndex + 1) % jokes.size
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Next Joke")
            }
        }
    }
}
@Composable
fun Greeting(joke: String) {
    Text(
        text = joke,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = LocalTextStyle.current.copy(
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1Theme {
        Greeting("Why did the chicken cross the road?\nTo get to the other side!")
    }
}