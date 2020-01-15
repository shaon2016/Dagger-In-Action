package com.mediasoft.daggerinaction.main

import android.annotation.SuppressLint
import android.util.Log
import com.mediasoft.daggerinaction.LoadDataCallback
import com.mediasoft.daggerinaction.RestApiClient
import com.mediasoft.daggerinaction.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserRepoImpl : UserRepo {
    private val userService = RestApiClient.getRetrofit().create(UserService::class.java)
    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun getUsers(callBack: LoadDataCallback<User>) {
        compositeDisposable.add(userService.users().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users ->
                callBack.onDataLoaded(users)
            }, {
                callBack.onDataNotAvailable()
                it.printStackTrace()
            }))

    }

    override fun clear() {
        Log.d("DATATAG", "Called")
        compositeDisposable.dispose()
    }

}