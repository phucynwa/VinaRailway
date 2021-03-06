package com.example.vinarailway.data.model

import android.net.Uri
import com.example.vinarailway.utils.ENCODE_UTF_8
import java.net.URLEncoder

data class DataRequest(
    val scheme: String,
    val authority: String,
    val paths: List<String>? = null,
    val queryParams: Map<String, Any>? = null
) {
    fun toUrl(): String = Uri.Builder().apply {
        scheme(scheme)
        authority(authority)
        paths?.forEach { appendPath(it) }
        queryParams?.forEach {
            val encodedValue = URLEncoder.encode(it.value.toString(), ENCODE_UTF_8)
            appendQueryParameter(it.key, encodedValue)
        }
    }.toString()
}
