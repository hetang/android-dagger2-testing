package com.fivestars.dagger2app

import android.app.Activity
import android.app.Application
import android.content.Context
import com.fivestars.dagger2app.common.dagger.AppComponent
import com.fivestars.dagger2app.common.dagger.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Hetang.Shah on 11/8/17.
 */
open class Dagger2Application : Application(), HasActivityInjector {
    lateinit var appComponent: AppComponent
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        inject()
    }

    override fun activityInjector() = activityInjector

    open fun inject() {
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)  // bootstrap app with Android activity injector
    }
}