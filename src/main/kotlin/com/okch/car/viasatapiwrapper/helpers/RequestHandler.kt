package com.okch.car.viasatapiwrapper.helpers

import org.springframework.beans.factory.annotation.Value
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URI
import java.util.stream.Collectors

class RequestHandler {

    @Value("\${api.url}")
    private val url = ""
    private val method = "POST"

    fun sendRequest(uri: String, body: String): String? {
        val connection = URI(url + uri).toURL().openConnection() as HttpURLConnection

        connection.requestMethod = method
        connection.doOutput = true

        OutputStreamWriter(connection.outputStream).use { it.write(body) }

        val responseCode = connection.responseCode

        if (responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = reader.lines().collect(Collectors.joining("\n"))
            reader.close()
            return response
        }

        return null
    }
}