package com.mediasoft.daggerinaction.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediasoft.daggerinaction.LoadDataCallback
import com.mediasoft.daggerinaction.base.BaseViewModel
import com.mediasoft.daggerinaction.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainVM(private val userRepoImpl: UserRepoImpl) : ViewModel() {

    private val usersLive_ = MutableLiveData<List<User>>()
    val usersLive: LiveData<List<User>> get() = usersLive_

    init {
        userRepoImpl.getUsers(object : LoadDataCallback<User> {
            override fun onDataLoaded(data: List<User>) {
                usersLive_.value = data
            }

            override fun onDataNotAvailable() {
                usersLive_.value = null
            }
        })
    }

    override fun onCleared() {
        userRepoImpl.clear()
        super.onCleared()
    }
}