package com.fivestars.dagger2app.dagger

import com.fivestars.dagger2app.task.dagger.TestTaskModule
import com.fivestars.dagger2app.task.dagger.TestTaskUseCaseModule
import com.fivestars.dagger2app.activities.TaskActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Hetang.Shah on 11/29/17.
 */
@Module
abstract class TestAppBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(TestTaskUseCaseModule::class, TestTaskModule::class))
    abstract fun bindTaskActivity(): TaskActivity
}