package com.mediasoft.daggerinaction.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mediasoft.daggerinaction.R
import com.mediasoft.daggerinaction.extensions.getViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by "Ashiq" on 01/15/2020.
 */

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var userRepoImpl: UserRepoImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainVM = ViewModelProviders.of(this, viewModelFactory)[MainVM::class.java]
        mainVM.usersLive.observe(this, Observer {
            it?.let {
                rvUsers.layoutManager = LinearLayoutManager(this)
                rvUsers.adapter = UserRvAdapter(it)
            }
        })
    }

}
