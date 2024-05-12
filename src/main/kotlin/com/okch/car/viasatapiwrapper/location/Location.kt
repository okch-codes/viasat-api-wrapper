package com.okch.car.viasatapiwrapper.location

import com.okch.car.viasatapiwrapper.Utils
import com.okch.car.viasatapiwrapper.helpers.ApisWrapper
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Location {

    @RequestMapping("/location")
    fun location(): Coordinates? {
        val response = ApisWrapper().requestPosition() ?: return null
        val (latitude, longitude) = Utils.parseCoordinates(response)
        return Coordinates(latitude, longitude)
    }
}