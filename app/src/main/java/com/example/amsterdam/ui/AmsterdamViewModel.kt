package com.example.amsterdam.ui

import androidx.lifecycle.ViewModel
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
import com.example.amsterdam.data.ScreenType
import com.example.amsterdam.data.local.LocalPlacesDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AmsterdamViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AmsterdamUiState())
    val uiState: StateFlow<AmsterdamUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val places: Map<PlaceType, List<Place>> =
            LocalPlacesDataProvider.allPlaces.groupBy { it.placeType }
        _uiState.value =
            AmsterdamUiState(
                places = places,
                currentSelectedPlace = places[PlaceType.CoffeeShop]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace
            )
    }

    fun updatePlaceScreenStates(place: Place) {
        _uiState.update {
            it.copy(
                currentSelectedPlace = place,
                currentScreen = ScreenType.Place
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedPlace = it.places[it.currentPlaceType]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace,
                currentScreen = ScreenType.Home
            )
        }
    }

    fun resetPlaceTypeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedPlace = it.places[it.currentPlaceType]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace,
                currentScreen = ScreenType.PlaceType
            )
        }
    }

    fun updateCurrentPlaceType(placeType: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceType = placeType,
                currentScreen = ScreenType.PlaceType
            )
        }
    }
}