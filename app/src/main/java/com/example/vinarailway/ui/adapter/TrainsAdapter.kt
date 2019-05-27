package com.example.vinarailway.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.vinarailway.R
import com.example.vinarailway.data.model.Train
import kotlinx.android.synthetic.main.item_train.view.*

class TrainsAdapter(
    private val context: Context,
    private var trains: ArrayList<Train>
) : BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
        LayoutInflater.from(context).inflate(R.layout.item_train, null).apply {
            with(getItem(position)) {
                textTrainLabel.text = trainLabel
                textDuration.text = " ($duration minutes)"
                textDepartureStation.text = "Ga $departureStationName"
                textArrivalStation.text = "Ga $arrivalStationName"
                textDepartureTime.text = departureTime
                textArrivalTime.text = arrivalTime
            }
        }

    override fun getItem(position: Int) = trains[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = trains.size
}
