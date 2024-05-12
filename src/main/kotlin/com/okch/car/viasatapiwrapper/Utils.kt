package com.okch.car.viasatapiwrapper

class Utils {
    companion object Parsers {
        fun parseCoordinates(response: String): Pair<Double, Double> {
            val parts = response.split("§")
            val firstValue = parts[3].toDouble()
            val secondValue = parts[4].toDouble()
            return Pair(firstValue, secondValue)
        }
    }
}