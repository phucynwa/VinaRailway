package com.example.vinarailway.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.util.*

fun Spinner.setOnItemSelectedListener(listener: () -> Unit) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) = listener()

        override fun onNothingSelected(parent: AdapterView<*>) {
        }
    }
}

@Throws(IOException::class)
fun HttpURLConnection.build(method: String) = apply {
    requestMethod = method
    connect()
}

@Throws(IOException::class)
fun InputStreamReader.getJsonString(): String {
    val reader = BufferedReader(this)
    return StringBuilder().apply {
        do {
            val inputLine = reader.readLine()
            inputLine?.let { append(inputLine) }
        } while (inputLine != null)
        reader.close()
    }.toString()
}
