package com.example.vinarailway.data.source.local

interface OnLoadedDataCallback<T> {
    fun onSuccess(data: T)
    fun onFailed(exception: Exception)
}
