package com.mediasoft.daggerinaction.ui.main

import android.annotation.SuppressLint
import com.mediasoft.daggerinaction.util.LoadDataCallback
import com.mediasoft.daggerinaction.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by "Ashiq" on 01/15/2020.
 */

class UserRepoImpl @Inject constructor(private val userService : UserService): UserRepo {
  //  private val userService = RestApiClient.getRetrofit().create(UserService::class.java)
    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun getUsers(callBack: LoadDataCallback<User>) {
        val disposable = userService.users().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users ->
                callBack.onDataLoaded(users)
            }, {
                callBack.onDataNotAvailable()
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    override fun clear() {
        compositeDisposable.dispose()
    }

}