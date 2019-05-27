package com.example.vinarailway.data.model

import com.example.vinarailway.utils.KEY_STATION_CODE
import com.example.vinarailway.utils.KEY_STATION_ID
import com.example.vinarailway.utils.KEY_STATION_NAME
import org.json.JSONObject

data class Station(
    val id: Int,
    val code: String,
    val name: String
) {
    constructor(jsonObject: JSONObject) : this(
        id = jsonObject.getInt(KEY_STATION_ID),
        code = jsonObject.getString(KEY_STATION_CODE),
        name = jsonObject.getString(KEY_STATION_NAME)
    )
}
