package com.mediasoft.daggerinaction.main

import com.mediasoft.daggerinaction.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserService {

    @GET("my_json")
    fun users() : Observable<List<User>>
}