package com.example.vinarailway.data.source

import com.example.vinarailway.data.model.TrainsResponse
import com.example.vinarailway.data.source.local.OnLoadedDataCallback

interface TrainsDataSource {
    interface Remote {
        fun getTrains(
            departureStationCode: String,
            arrivalStationCode: String,
            day: String,
            callback: OnLoadedDataCallback<TrainsResponse>
        )
    }
}
