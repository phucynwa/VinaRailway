package com.example.vinarailway.ui.main

import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.model.TrainsResponse

interface MainContract {
    interface View {
        fun setPresenter(presenter: Presenter)
        fun showTrains(data: TrainsResponse)
        fun showStations(data: StationsResponse)
        fun showError()
    }

    interface Presenter {
        fun getStations()
        fun getTrains(departureStationCode: String, arrivalStationCode: String, day: String)
    }
}