package com.mediasoft.daggerinaction.main

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mediasoft.daggerinaction.RestApiClient
import com.mediasoft.daggerinaction.UserService
import com.mediasoft.daggerinaction.base.BaseViewModel
import com.mediasoft.daggerinaction.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainVM : BaseViewModel() {
    val userService = RestApiClient.getRetrofit().create(UserService::class.java)

    private val usersLive_ = MutableLiveData<List<User>>()
    val usersLive: LiveData<List<User>> get() = usersLive_

    init {
        getUsers()
    }

    @SuppressLint("CheckResult")
    private fun getUsers() {

        userService.users().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .subscribe({users->
                usersLive_.value = users
            }, {it.printStackTrace()})
    }
}