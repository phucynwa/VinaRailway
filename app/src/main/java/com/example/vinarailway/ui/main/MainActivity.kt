package com.example.vinarailway.ui.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.vinarailway.R
import com.example.vinarailway.data.model.Station
import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.model.Train
import com.example.vinarailway.data.model.TrainsResponse
import com.example.vinarailway.data.source.remote.StationsRemoteDataSource
import com.example.vinarailway.data.source.remote.TrainsRemoteDataSource
import com.example.vinarailway.data.source.repository.StationRepository
import com.example.vinarailway.data.source.repository.TrainRepository
import com.example.vinarailway.ui.adapter.StationsAdapter
import com.example.vinarailway.ui.adapter.TrainsAdapter
import com.example.vinarailway.utils.REQUEST_DATE_FORMAT
import com.example.vinarailway.utils.VIEW_DATE_FORMAT
import com.example.vinarailway.utils.setOnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : FragmentActivity(), MainContract.View {

    private lateinit var mainPresenter: MainContract.Presenter
    private lateinit var dateDeparture: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        initListener()
    }

    private fun initData() {
        mainPresenter = MainPresenter(
            mainView = this,
            stationRepository = StationRepository.fromDataSource(StationsRemoteDataSource),
            trainRepository = TrainRepository.fromDataSource(TrainsRemoteDataSource)
        )
        mainPresenter.getStations()
        dateDeparture = Calendar.getInstance()
    }

    private fun initView() {
        textDepartureDay.text = SimpleDateFormat(VIEW_DATE_FORMAT, Locale.US).format(dateDeparture.time)
    }

    private fun initListener() {
        textDepartureDay.setOnClickListener {
            DatePickerDialog(
                this,
                R.style.MySpinnerDatePickerStyle,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    dateDeparture.set(year, month, dayOfMonth)
                    textDepartureDay.text = SimpleDateFormat(VIEW_DATE_FORMAT, Locale.US).format(dateDeparture.time)
                    requestTrains()
                },
                dateDeparture.get(Calendar.YEAR),
                dateDeparture.get(Calendar.MONTH),
                dateDeparture.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        spinnerDepartureStations.setOnItemSelectedListener { requestTrains() }
        spinnerArrivalStations.setOnItemSelectedListener { requestTrains() }
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        mainPresenter = presenter
    }

    override fun showStations(data: StationsResponse) {
        spinnerDepartureStations.adapter = StationsAdapter(this, data.stations as ArrayList<Station>)
        spinnerArrivalStations.adapter = StationsAdapter(this, data.stations)
    }

    override fun showTrains(data: TrainsResponse) {
        listTrains.adapter = TrainsAdapter(this, data.trains as ArrayList<Train>)
        if (data.trains.isEmpty()) {
            Toast.makeText(this, getString(R.string.text_empty_response_notice), Toast.LENGTH_LONG).show()
        }
    }

    private fun requestTrains() {
        mainPresenter.getTrains(
            departureStationCode = (spinnerDepartureStations.selectedItem as Station).code,
            arrivalStationCode = (spinnerArrivalStations.selectedItem as Station).code,
            day = SimpleDateFormat(REQUEST_DATE_FORMAT, Locale.US).format(dateDeparture.time)
        )
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.text_error_notice), Toast.LENGTH_LONG).show()
    }
}
