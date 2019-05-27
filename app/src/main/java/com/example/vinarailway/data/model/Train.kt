package com.example.vinarailway.data.model

import com.example.vinarailway.utils.*
import org.json.JSONObject

data class Train(
    val id: Int,
    val trainLabel: String,
    val duration: Int,
    val departureStationCode: String,
    val arrivalStationCode: String,
    val departureStationName: String,
    val arrivalStationName: String,
    val departureTime: String,
    val arrivalTime: String
) {
    constructor(jsonObject: JSONObject) : this(
        id = jsonObject.getInt(KEY_ID),
        trainLabel = jsonObject.getString(KEY_TRAIN_LABEL),
        duration = jsonObject.getInt(KEY_DURATION),
        departureStationCode = jsonObject.getString(KEY_DEPARTURE_STATION_CODE),
        arrivalStationCode = jsonObject.getString(KEY_ARRIVAL_STATION_CODE),
        departureStationName = jsonObject.getString(KEY_DEPARTURE_STATION_NAME),
        arrivalStationName = jsonObject.getString(KEY_ARRIVAL_STATION_NAME),
        departureTime = jsonObject.getString(KEY_DEPARTURE_TIME),
        arrivalTime = jsonObject.getString(KEY_ARRIVAL_TIME)
    )
}
