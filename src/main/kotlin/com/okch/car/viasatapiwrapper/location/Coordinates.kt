package com.okch.car.viasatapiwrapper.location

data class Coordinates(
    val latitude: Double,
    val longitude: Double,
    val gmapsUrl: String = "https://www.google.com/maps/search/?api=1&query=$latitude,$longitude"
)