package com.mediasoft.daggerinaction.di

import com.mediasoft.daggerinaction.MyApp
import com.mediasoft.daggerinaction.di.module.AndroidBindingModule
import com.mediasoft.daggerinaction.di.module.NetworkModule
import com.mediasoft.daggerinaction.di.module.UserModule
import com.mediasoft.daggerinaction.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by "Ashiq" on 01/15/2020.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AndroidBindingModule::class,
UserModule::class,  NetworkModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<MyApp>