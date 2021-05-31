package com.example.paypaycodechallenge

import android.app.Application

class MyBaseApplication : Application() {
    companion object {
        private var instance: MyBaseApplication? = null

        @Synchronized
        fun getInstance(): MyBaseApplication? {
            return MyBaseApplication.instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}