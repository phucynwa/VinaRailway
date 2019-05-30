package com.example.vinarailway.data.source.remote.response

import com.example.vinarailway.utils.METHOD_GET
import com.example.vinarailway.utils.build
import com.example.vinarailway.utils.getJsonString
import org.json.JSONException
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

interface DataResponseHandler<T> {

    @Throws(JSONException::class)
    fun parseToObject(jsonString: String): T

    @Throws(IOException::class, JSONException::class)
    fun getResponse(url: String): T? {
        var responseData: T?
        var connection: HttpURLConnection? = null
        try {
            connection = (URL(url).openConnection() as HttpURLConnection).apply {
                build(METHOD_GET)
                if (responseCode != HttpURLConnection.HTTP_OK) throw IOException(responseCode.toString())
                InputStreamReader(inputStream).run {
                    responseData = parseToObject(getJsonString())
                    close()
                }
            }
        } finally {
            connection?.disconnect()
        }
        return responseData
    }
}
