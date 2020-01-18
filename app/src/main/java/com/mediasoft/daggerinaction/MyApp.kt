package com.mediasoft.daggerinaction

import android.app.Application
import com.mediasoft.daggerinaction.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by "Ashiq" on 01/15/2020.
 */

class MyApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        DaggerAppComponent.create().inject(this)
        super.onCreate()
    }
}