package com.fivestars.dagger2app.common.dagger

import com.fivestars.dagger2app.activities.TaskActivity
import com.fivestars.dagger2app.activities.dagger.TaskModule
import com.fivestars.domain.dagger.modules.TaskUseCaseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Hetang.Shah on 11/29/17.
 */
/**
 * Dagger module which defines subcomponents for Activities. This allows the AndroidInjector to
 * find the correct component to build when AndroidInjection.inject is called with an Activity.
 * This module will contain a reference to all Activity components known by the Application
 */
@Module
abstract class AppBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(TaskUseCaseModule::class, TaskModule::class))
    abstract fun bindTaskActivity(): TaskActivity

    // Add more Activity Binding here
}