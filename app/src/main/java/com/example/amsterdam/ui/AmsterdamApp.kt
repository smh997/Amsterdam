package com.example.amsterdam.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.amsterdam.ui.theme.AmsterdamTheme

@Composable
fun AmsterdamApp(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun AmsterdamPreview() {
    AmsterdamTheme {
        AmsterdamApp()
    }
}