package com.example.amsterdam.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Long,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val address: Int,
    @StringRes val googleMapsUrl: Int,
    val placeType: PlaceType = PlaceType.CoffeeShop,
    @DrawableRes val imageRes: Int
)
