package com.example.vinarailway.data.source

import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.source.local.OnLoadedDataCallback

interface StationsDataSource {
    interface Remote {
        fun getStations(callback: OnLoadedDataCallback<StationsResponse>)
    }
}
