package com.boggle.wall.base

import android.app.Application
import com.boggle.wall.http.RetrofitHelper

class APP : Application() {
    companion object {
        public lateinit var mInstance: APP

        fun getInstance() = mInstance
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        RetrofitHelper.initOkHttpClient(applicationContext)
    }
}