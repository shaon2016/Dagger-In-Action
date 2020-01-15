package com.mediasoft.daggerinaction.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mediasoft.daggerinaction.base.BaseViewModel
import com.mediasoft.daggerinaction.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainVM(private val userRepoImpl: UserRepoImpl) : BaseViewModel() {

    private val usersLive_ = MutableLiveData<List<User>>()
    val usersLive: LiveData<List<User>> get() = usersLive_

    init {
        getUsers()
    }

    @SuppressLint("CheckResult")
    private fun getUsers() {
        userRepoImpl.users().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .subscribe({users->
                usersLive_.value = users
            }, {it.printStackTrace()})
    }
}