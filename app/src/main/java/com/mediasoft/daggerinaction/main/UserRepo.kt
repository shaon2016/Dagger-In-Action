package com.mediasoft.daggerinaction.main

import com.mediasoft.daggerinaction.model.User
import io.reactivex.Observable

interface UserRepo {
    fun users() : Observable<List<User>>
}