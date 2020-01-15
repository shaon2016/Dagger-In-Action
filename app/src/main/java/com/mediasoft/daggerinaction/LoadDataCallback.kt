package com.mediasoft.daggerinaction

interface LoadDataCallback<T> {

    fun onDataLoaded(data: List<T>)

    fun onDataNotAvailable()
}