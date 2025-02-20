package com.example.amsterdam.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
import com.example.compose.AmsterdamTheme

@Composable
fun AmsterdamApp(
    modifier: Modifier = Modifier
) {
    val viewModel: AmsterdamViewModel = viewModel()
    val amsterdamUiState: AmsterdamUiState = viewModel.uiState.collectAsState().value
    HomeScreen(
        amsterdamUiState = amsterdamUiState,
        onTabPressed = { placeType: PlaceType ->
            viewModel.updateCurrentPlaceType(placeType = placeType)
        },
        onPlaceCardPressed = { place: Place ->
            viewModel.updatePlaceScreenStates(
                place = place
            )
        },
        onPlaceTypeScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        onPlaceScreenBackPressed = {
            viewModel.resetPlaceTypeScreenStates()
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AmsterdamPreview() {
    AmsterdamTheme {
        AmsterdamApp()
    }
}