package com.mediasoft.daggerinaction.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediasoft.daggerinaction.util.LoadDataCallback
import com.mediasoft.daggerinaction.model.User
import javax.inject.Inject

/**
 * Created by "Ashiq" on 01/15/2020.
 */

class MainVM @Inject constructor(private val userRepoImpl: UserRepoImpl) : ViewModel() {

    private val usersLive_ = MutableLiveData<List<User>>()
    val usersLive: LiveData<List<User>> get() = usersLive_

    init {
        userRepoImpl.getUsers(object :
            LoadDataCallback<User> {
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