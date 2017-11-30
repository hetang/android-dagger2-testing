package com.fivestars.dagger2app

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.fivestars.dagger2app.dagger.DaggerTestAppComponent

/**
 * Created by Hetang.Shah on 11/29/17.
 */
class TestApplication : Dagger2Application() {

    override fun inject() {
        appComponent = DaggerTestAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }
}

class TestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.qualifiedName, context)
    }
}