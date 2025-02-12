package com.example.amsterdam.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AmsterdamTheme

@Composable
fun AmsterdamApp(modifier: Modifier = Modifier) {
    HomeScreen(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun AmsterdamPreview() {
    AmsterdamTheme {
        AmsterdamApp()
    }
}