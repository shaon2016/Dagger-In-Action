package com.mediasoft.daggerinaction.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mediasoft.daggerinaction.di.ViewModelKey
import com.mediasoft.daggerinaction.ui.main.MainVM
import com.mediasoft.daggerinaction.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 *  Collected from google sample // Github Browser sample
 *
 *  */

@Module
abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainVM::class)
  abstract fun bindMainViewModel(mainVm: MainVM): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
