package com.example.vinarailway.data.source.remote

import com.example.vinarailway.data.model.DataRequest
import com.example.vinarailway.data.model.TrainsResponse
import com.example.vinarailway.data.source.TrainsDataSource
import com.example.vinarailway.data.source.local.OnLoadedDataCallback
import com.example.vinarailway.data.source.remote.response.GetResponsesAsync
import com.example.vinarailway.data.source.remote.response.TrainsResponseHandler
import com.example.vinarailway.utils.*

object TrainsRemoteDataSource : TrainsDataSource.Remote {
    override fun getTrains(
        departureStationCode: String,
        arrivalStationCode: String,
        day: String,
        callback: OnLoadedDataCallback<TrainsResponse>
    ) {
        val urlRequest = DataRequest(
            scheme = SCHEME_HTTPS,
            authority = AUTHORITY_VN_TICKET_ONLINE,
            paths = listOf(PATH_API, PATH_GTGV, PATH_LOAD_TRAINS),
            queryParams = mapOf(
                QUERY_DEPARTURE_CODE to departureStationCode,
                QUERY_ARRIVAL_CODE to arrivalStationCode,
                QUERY_DEPARTURE_DAY to day
            )
        ).toUrl()
        GetResponsesAsync(TrainsResponseHandler(), callback).execute(urlRequest)
    }
}
