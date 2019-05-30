package com.example.vinarailway.data.source.remote.response

import com.example.vinarailway.data.model.StationsResponse
import org.json.JSONArray

class StationsResponseHandler : DataResponseHandler<StationsResponse> {
    override fun parseToObject(jsonString: String): StationsResponse =
        StationsResponse(JSONArray(jsonString))
}
