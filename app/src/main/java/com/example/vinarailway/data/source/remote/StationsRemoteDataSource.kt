package com.example.vinarailway.data.source.remote

import com.example.vinarailway.data.model.DataRequest
import com.example.vinarailway.data.model.StationsResponse
import com.example.vinarailway.data.source.StationsDataSource
import com.example.vinarailway.data.source.local.OnLoadedDataCallback
import com.example.vinarailway.data.source.remote.response.GetResponsesAsync
import com.example.vinarailway.data.source.remote.response.StationsResponseHandler
import com.example.vinarailway.utils.*

object StationsRemoteDataSource : StationsDataSource.Remote {
    override fun getStations(callback: OnLoadedDataCallback<StationsResponse>) {
        val urlRequest = DataRequest(
            scheme = SCHEME_HTTPS,
            authority = AUTHORITY_VN_TICKET_ONLINE,
            paths = listOf(PATH_API, PATH_GTGV, PATH_LOAD_STATIONS)
        ).toUrl()
        GetResponsesAsync(StationsResponseHandler(), callback).execute(urlRequest)
    }
}
