package com.example.vinarailway.ui.main

import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.model.TrainsResponse
import com.example.vinarailway.data.source.local.OnLoadedDataCallback
import com.example.vinarailway.data.source.repository.StationRepository
import com.example.vinarailway.data.source.repository.TrainRepository

class MainPresenter(
    private val mainView: MainContract.View,
    private val trainRepository: TrainRepository,
    private val stationRepository: StationRepository
) : MainContract.Presenter {

    init {
        mainView.setPresenter(this)
    }

    override fun getStations() {
        val callback = object : OnLoadedDataCallback<StationsResponse> {
            override fun onSuccess(data: StationsResponse) = mainView.showStations(data)

            override fun onFailed(exception: Exception) = mainView.showError()
        }
        stationRepository.getStations(callback)
    }

    override fun getTrains(
        departureStationCode: String,
        arrivalStationCode: String,
        day: String
    ) {
        val callback = object : OnLoadedDataCallback<TrainsResponse> {
            override fun onSuccess(data: TrainsResponse) = mainView.showTrains(data)

            override fun onFailed(exception: Exception) = mainView.showError()
        }
        trainRepository.getTrains(departureStationCode, arrivalStationCode, day, callback)
    }
}
