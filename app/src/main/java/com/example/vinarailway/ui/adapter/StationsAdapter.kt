package com.example.vinarailway.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.vinarailway.R
import com.example.vinarailway.data.model.Station
import kotlinx.android.synthetic.main.item_station.view.*

class StationsAdapter(
    private val context: Context,
    private var stations: ArrayList<Station>
) : BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
        LayoutInflater.from(context).inflate(R.layout.item_station, null).apply {
            with(getItem(position)) {
                textStationName.text = name
            }
        }

    override fun getItem(position: Int) = stations[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = stations.size
}
