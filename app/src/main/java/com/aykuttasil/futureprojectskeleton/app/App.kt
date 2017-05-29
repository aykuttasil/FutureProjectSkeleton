package com.aykuttasil.futureprojectskeleton.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowLog
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by aykutasil on 19.05.2017.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build())
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V)

        Stetho.initializeWithDefaults(this)
    }
}