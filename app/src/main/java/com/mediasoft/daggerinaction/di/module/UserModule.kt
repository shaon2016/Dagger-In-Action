package com.mediasoft.daggerinaction.di.module

import com.mediasoft.daggerinaction.ui.main.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
/**
 * Created by "Ashiq" on 01/15/2020.
 */
@Module
class UserModule {
    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}