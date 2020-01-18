package com.mediasoft.daggerinaction.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by "Ashiq" on 01/15/2020.
 */
class BaseViewModelFactory<T>(val creator : () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }

}