package com.example.amsterdam.data

import androidx.annotation.DrawableRes
import com.example.amsterdam.R

enum class PlaceType(val label: String, @DrawableRes val imageRes: Int, @DrawableRes val iconRes: Int) {
    CoffeeShop("Coffee Shop", R.drawable.coffeeshop, R.drawable.local_cafe_24),
    Restaurant("Restaurant", R.drawable.restaurant, R.drawable.restaurant_24),
    KidsFriendly("Kids Friendly", R.drawable.nemo_science_museum, R.drawable.toys_fan_24),
    Park("Park", R.drawable.oosterpark, R.drawable.park_24),
    ShoppingCenter("Shopping Center", R.drawable.de_bijenkorf, R.drawable.local_mall_24)
}
