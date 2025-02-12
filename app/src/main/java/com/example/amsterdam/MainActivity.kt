package com.example.amsterdam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.amsterdam.ui.AmsterdamApp
import com.example.compose.AmsterdamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmsterdamTheme {
                Surface {
                    AmsterdamApp()
                }
            }
        }
    }
}

