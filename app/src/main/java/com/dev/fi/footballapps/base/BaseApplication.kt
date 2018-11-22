package com.dev.fi.footballschedule2.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(2)
                .methodOffset(5)
                .tag("FootballSchedule2")
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}