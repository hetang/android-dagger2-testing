package com.fivestars.dagger2app

import android.app.Application
import android.content.Context

/**
 * Created by Hetang.Shah on 11/8/17.
 */
class Dagger2Application : Application() {
    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}