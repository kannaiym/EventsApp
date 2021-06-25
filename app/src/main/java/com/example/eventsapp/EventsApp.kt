package com.example.eventsapp

import android.app.Application
import com.example.eventsapp.data.di.appModules
import com.example.eventsapp.data.local.PreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EventsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(applicationContext)
        startKoin {
            androidContext(this@EventsApp)
            modules(appModules)
        }
    }
}