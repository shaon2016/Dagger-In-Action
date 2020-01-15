package com.mediasoft.daggerinaction.ui.main

import com.mediasoft.daggerinaction.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by "Ashiq" on 01/15/2020.
 */

interface UserService {

    @GET("my_json")
    fun users() : Observable<List<User>>
}