package com.example.amsterdam.ui

import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
import com.example.amsterdam.data.ScreenType
import com.example.amsterdam.data.local.LocalPlacesDataProvider

data class AmsterdamUiState(
    val places: Map<PlaceType, List<Place>> = emptyMap(),
    val currentPlaceType: PlaceType = PlaceType.CoffeeShop,
    val currentSelectedPlace: Place = LocalPlacesDataProvider.defaultPlace,
    val homeScreenType: ScreenType = ScreenType.Home,
    val currentScreen: ScreenType = homeScreenType
) {
    val currentPlaces: List<Place> by lazy { places[currentPlaceType]!! }
}
