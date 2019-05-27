package com.example.vinarailway.data.source.remote.response

import android.os.AsyncTask
import com.example.vinarailway.data.source.local.OnLoadedDataCallback

class GetResponsesAsync<T>(
    private val responseHandler: DataResponseHandler<T>,
    private val callback: OnLoadedDataCallback<T>
) : AsyncTask<String, Void, Exception?>() {

    private var result: T? = null

    override fun doInBackground(vararg params: String): Exception? = try {
        result = responseHandler.getResponse(params[0])
        null
    } catch (exception: Exception) {
        exception
    }

    override fun onPostExecute(exception: Exception?) {
        if (exception == null) result?.let { callback.onSuccess(it) }
        else callback.onFailed(exception)
    }
}
