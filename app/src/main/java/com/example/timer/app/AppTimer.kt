package com.example.timer.app

import android.app.Application
import com.example.timer.di.appModule
import com.example.timer.di.dataModule
import com.example.timer.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppTimer: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppTimer)
            modules(listOf(appModule,dataModule,domainModule))
        }

    }
}