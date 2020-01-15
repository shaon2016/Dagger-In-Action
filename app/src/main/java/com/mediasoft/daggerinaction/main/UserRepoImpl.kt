package com.mediasoft.daggerinaction.main

import com.mediasoft.daggerinaction.UserService
import com.mediasoft.daggerinaction.model.User
import io.reactivex.Observable

class UserRepoImpl(private val userService: UserService) : UserRepo {

    override fun users(): Observable<List<User>> {
        return userService.users()
    }

}