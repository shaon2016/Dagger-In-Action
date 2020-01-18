package com.mediasoft.daggerinaction.di.module

import com.mediasoft.daggerinaction.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
/**
 * Created by "Ashiq" on 01/15/2020.
 */
@Module
abstract class AndroidBindingModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}