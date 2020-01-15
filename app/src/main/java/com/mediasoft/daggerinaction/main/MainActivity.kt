package com.mediasoft.daggerinaction.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mediasoft.daggerinaction.R
import com.mediasoft.daggerinaction.RestApiClient
import com.mediasoft.daggerinaction.UserService
import com.mediasoft.daggerinaction.getViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainVM: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVar()
        initView()
    }

    private fun initView() {
        mainVM.usersLive.observe(this, Observer {
            it?.let {
                rvUsers.layoutManager = LinearLayoutManager(this)
                rvUsers.adapter = UserRvAdapter(it)
            }
        })

    }

    private fun initVar() {
        // mainVM = ViewModelProviders.of(this).get(MainVM::class.java)
        val userService = RestApiClient.getRetrofit().create(UserService::class.java)

        val userRepoImpl = UserRepoImpl(userService)
        mainVM = getViewModel {
            MainVM(userRepoImpl)
        }
    }
}
