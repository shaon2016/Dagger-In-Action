package com.mediasoft.daggerinaction.main

import com.mediasoft.daggerinaction.RestApiClient
import com.mediasoft.daggerinaction.model.User
import io.reactivex.Observable

class UserRepoImpl : UserRepo {
    private val userService = RestApiClient.getRetrofit().create(UserService::class.java)

    override fun users(): Observable<List<User>> {
        return userService.users()
    }
}