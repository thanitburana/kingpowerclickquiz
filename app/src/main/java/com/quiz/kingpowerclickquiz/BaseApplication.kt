package com.quiz.kingpowerclickquiz

import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    companion object {
        private lateinit var context: Context
        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }
}