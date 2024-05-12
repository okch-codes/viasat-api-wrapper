package com.okch.car.viasatapiwrapper.statistics

import com.okch.car.viasatapiwrapper.helpers.ApisWrapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Month
import java.time.Year

@RestController
class Statistics {

    @GetMapping("/statistics")
    fun statistics(@RequestParam year: Year, @RequestParam month: Month): String {
        val response = ApisWrapper().requestStatistics(year, month) ?: return "No statistics available"
        return response
    }
}