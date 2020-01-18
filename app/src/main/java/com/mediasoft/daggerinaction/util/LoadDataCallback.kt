package com.mediasoft.daggerinaction.util

/**
 * Created by "Ashiq" on 01/15/2020.
 */

interface LoadDataCallback<T> {

    fun onDataLoaded(data: List<T>)

    fun onDataNotAvailable()
}