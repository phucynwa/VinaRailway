package com.example.vinarailway.data.model

import org.json.JSONArray

data class StationsResponse(val stations: List<Station>) {

    constructor(jsonArray: JSONArray) : this (
        ArrayList<Station>().apply {
            for (index in 0 until jsonArray.length()) {
                add(Station(jsonArray.getJSONObject(index)))
            }
        }
    )
}
