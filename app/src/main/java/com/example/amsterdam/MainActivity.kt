package com.example.amsterdam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.amsterdam.ui.AmsterdamApp
import com.example.compose.AmsterdamTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmsterdamTheme (dynamicColor = false) {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    AmsterdamApp(windowSize.widthSizeClass)
                }
            }
        }
    }
}

