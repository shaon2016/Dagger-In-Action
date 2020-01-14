package com.mediasoft.daggerinaction.di

import com.mediasoft.daggerinaction.MyApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<MyApp>