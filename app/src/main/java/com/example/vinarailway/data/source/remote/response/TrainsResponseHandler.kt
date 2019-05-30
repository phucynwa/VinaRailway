package com.example.vinarailway.data.source.remote.response

import com.example.vinarailway.data.model.TrainsResponse
import org.json.JSONArray

class TrainsResponseHandler : DataResponseHandler<TrainsResponse> {
    override fun parseToObject(jsonString: String): TrainsResponse =
        TrainsResponse(JSONArray(jsonString))
}
