package com.example.amsterdam.data.local

import com.example.amsterdam.R
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType

object LocalPlacesDataProvider {
    val allPlaces = listOf(
        Place(
            id = 0L,
            name = R.string.Cafe1_name,
            description = R.string.Cafe1_description,
            address = R.string.Cafe1_address,
            googleMapsUrl = R.string.Cafe1_address_url,
            category = PlaceType.CoffeeShop
        ),
        Place(
            id = 1L,
            name = R.string.Cafe2_name,
            description = R.string.Cafe2_description,
            address = R.string.Cafe2_address,
            googleMapsUrl = R.string.Cafe2_address_url,
            category = PlaceType.CoffeeShop
        ),
        Place(
            id = 2L,
            name = R.string.Cafe3_name,
            description = R.string.Cafe3_description,
            address = R.string.Cafe3_address,
            googleMapsUrl = R.string.Cafe3_address_url,
            category = PlaceType.CoffeeShop
        ),
        Place(
            id = 3L,
            name = R.string.Restaurant1_name,
            description = R.string.Restaurant1_description,
            address = R.string.Restaurant1_address,
            googleMapsUrl = R.string.Restaurant1_address_url,
            category = PlaceType.Restaurant
        ),
        Place(
            id = 4L,
            name = R.string.Restaurant2_name,
            description = R.string.Restaurant2_description,
            address = R.string.Restaurant2_address,
            googleMapsUrl = R.string.Restaurant2_address_url,
            category = PlaceType.Restaurant
        ),
        Place(
            id = 5L,
            name = R.string.Restaurant3_name,
            description = R.string.Restaurant3_description,
            address = R.string.Restaurant3_address,
            googleMapsUrl = R.string.Restaurant3_address_url,
            category = PlaceType.Restaurant
        ),
        Place(
            id = 6L,
            name = R.string.Kids_Friendly1_name,
            description = R.string.Kids_Friendly1_description,
            address = R.string.Kids_Friendly1_address,
            googleMapsUrl = R.string.Kids_Friendly1_address_url,
            category = PlaceType.KidsFriendly
        ),
        Place(
            id = 7L,
            name = R.string.Kids_Friendly2_name,
            description = R.string.Kids_Friendly2_description,
            address = R.string.Kids_Friendly2_address,
            googleMapsUrl = R.string.Kids_Friendly2_address_url,
            category = PlaceType.KidsFriendly
        ),
        Place(
            id = 8L,
            name = R.string.Kids_Friendly3_name,
            description = R.string.Kids_Friendly3_description,
            address = R.string.Kids_Friendly3_address,
            googleMapsUrl = R.string.Kids_Friendly3_address_url,
            category = PlaceType.KidsFriendly
        ),
        Place(
            id = 9L,
            name = R.string.Park1_name,
            description = R.string.Park1_description,
            address = R.string.Park1_address,
            googleMapsUrl = R.string.Park1_address_url,
            category = PlaceType.Park
        ),
        Place(
            id = 10L,
            name = R.string.Park2_name,
            description = R.string.Park2_description,
            address = R.string.Park2_address,
            googleMapsUrl = R.string.Park2_address_url,
            category = PlaceType.Park
        ),
        Place(
            id = 11L,
            name = R.string.Park3_name,
            description = R.string.Park3_description,
            address = R.string.Park3_address,
            googleMapsUrl = R.string.Park3_address_url,
            category = PlaceType.Park
        ),
        Place(
            id = 12L,
            name = R.string.Shopping1_name,
            description = R.string.Shopping1_description,
            address = R.string.Shopping1_address,
            googleMapsUrl = R.string.Shopping1_address_url,
            category = PlaceType.ShoppingCenter
        ),
        Place(
            id = 13L,
            name = R.string.Shopping2_name,
            description = R.string.Shopping2_description,
            address = R.string.Shopping2_address,
            googleMapsUrl = R.string.Shopping2_address_url,
            category = PlaceType.ShoppingCenter
        ),
        Place(
            id = 14L,
            name = R.string.Shopping3_name,
            description = R.string.Shopping3_description,
            address = R.string.Shopping3_address,
            googleMapsUrl = R.string.Shopping3_address_url,
            category = PlaceType.ShoppingCenter
        )
    )

    val defaultPlace = allPlaces.getOrNull(0)

    fun get(id: Long): Place? {
        return allPlaces.firstOrNull { it.id == id }
    }
}