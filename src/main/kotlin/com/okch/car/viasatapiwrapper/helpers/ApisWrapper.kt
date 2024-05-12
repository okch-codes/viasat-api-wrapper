package com.okch.car.viasatapiwrapper.helpers

import org.springframework.beans.factory.annotation.Value
import java.time.Month
import java.time.Year

class ApisWrapper {

    private val requestHandler = RequestHandler()

    @Value("\${api.location.body}")
    private val requestLocationBody = ""

    @Value("\${api.statistics.body}")
    private val requestStatisticsBody = ""

    fun requestStatistics(year: Year, month: Month): String? {
        return requestHandler.sendRequest("/restpostgetstatisticsreale", requestStatisticsBody
            .replace("__YYYY__", year.toString())
            .replace("__MM__", month.value.toString()))
    }

    fun requestPosition(): String? {
        return requestHandler.sendRequest("/restpostlastpositionreale", requestLocationBody)
    }
}