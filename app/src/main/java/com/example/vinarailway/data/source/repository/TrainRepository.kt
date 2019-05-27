package com.example.vinarailway.data.source.repository

import com.example.vinarailway.data.model.TrainsResponse
import com.example.vinarailway.data.source.TrainsDataSource
import com.example.vinarailway.data.source.local.OnLoadedDataCallback
import com.example.vinarailway.data.source.remote.TrainsRemoteDataSource

object TrainRepository : TrainsDataSource.Remote {

    private lateinit var dataSource: TrainsRemoteDataSource

    fun fromDataSource(trainsRemoteDataSource: TrainsRemoteDataSource): TrainRepository =
        apply { dataSource = trainsRemoteDataSource }

    override fun getTrains(
        departureStationCode: String,
        arrivalStationCode: String,
        day: String,
        callback: OnLoadedDataCallback<TrainsResponse>
    ) = dataSource.getTrains(departureStationCode, arrivalStationCode, day, callback)
}
