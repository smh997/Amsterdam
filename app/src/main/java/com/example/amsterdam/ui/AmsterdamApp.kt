package com.example.amsterdam.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
import com.example.amsterdam.data.ScreenType
import com.example.amsterdam.ui.utils.NavigationType
import com.example.compose.AmsterdamTheme

@Composable
fun AmsterdamApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val navigationType = when(windowSize){
        WindowWidthSizeClass.Compact -> {
            NavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            NavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            NavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            NavigationType.BOTTOM_NAVIGATION
        }
    }
    val homeScreen: ScreenType = when(navigationType){
        NavigationType.BOTTOM_NAVIGATION -> ScreenType.Home
        NavigationType.NAVIGATION_RAIL -> ScreenType.PlaceType
        NavigationType.PERMANENT_NAVIGATION_DRAWER -> ScreenType.Place
    }
    val viewModel: AmsterdamViewModel = viewModel(factory = AmsterdamViewModel.provideFactory(homeScreen))
    val amsterdamUiState: AmsterdamUiState = viewModel.uiState.collectAsState().value
    HomeScreen(
        amsterdamUiState = amsterdamUiState,
        navigationType = navigationType,
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
        onNextPlaceClicked = { place: Place ->
            viewModel.updatePlaceScreenStates(place)
        },
        onPreviousPlaceClicked = { place: Place ->
            viewModel.updatePlaceScreenStates(place)
        },
        modifier = modifier.statusBarsPadding().navigationBarsPadding()
    )
}

@Preview(showBackground = true)
@Composable
fun AmsterdamPreview() {
    AmsterdamTheme {
        AmsterdamApp(WindowWidthSizeClass.Compact)
    }
}