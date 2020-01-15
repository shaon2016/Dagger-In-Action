package com.mediasoft.daggerinaction.ui.main

import com.mediasoft.daggerinaction.util.LoadDataCallback
import com.mediasoft.daggerinaction.base.BaseRepo
import com.mediasoft.daggerinaction.model.User

/**
 * Created by "Ashiq" on 01/15/2020.
 */

interface UserRepo : BaseRepo{
    fun getUsers(callBack : LoadDataCallback<User>)
}