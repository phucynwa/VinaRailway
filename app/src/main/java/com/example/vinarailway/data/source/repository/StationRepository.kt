package com.example.vinarailway.data.source.repository

import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.source.StationsDataSource
import com.example.vinarailway.data.source.local.OnLoadedDataCallback
import com.example.vinarailway.data.source.remote.StationsRemoteDataSource

object StationRepository : StationsDataSource.Remote {

    private lateinit var dataSource: StationsRemoteDataSource

    fun fromDataSource(stationsRemoteDataSource: StationsRemoteDataSource) =
        apply { dataSource = stationsRemoteDataSource }

    override fun getStations(callback: OnLoadedDataCallback<StationsResponse>) {
        dataSource.getStations(callback)
    }
}
