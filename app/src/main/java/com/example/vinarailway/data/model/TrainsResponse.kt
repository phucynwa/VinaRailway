package com.example.vinarailway.data.model

import org.json.JSONArray

data class TrainsResponse(val trains: List<Train>) {
    constructor(jsonArray: JSONArray) : this(
        trains = ArrayList<Train>().apply {
            for (index in 0 until jsonArray.length()) {
                add(Train(jsonArray.getJSONObject(index)))
            }
        }
    )
}
