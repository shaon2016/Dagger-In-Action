package com.mediasoft.daggerinaction.main

import com.mediasoft.daggerinaction.LoadDataCallback
import com.mediasoft.daggerinaction.base.BaseRepo
import com.mediasoft.daggerinaction.model.User

interface UserRepo : BaseRepo{
    fun getUsers(callBack : LoadDataCallback<User>)
}