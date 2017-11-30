package com.fivestars.dagger2app.dagger

import android.content.Context
import com.fivestars.dagger2app.TestApplication
import com.fivestars.dagger2app.common.dagger.AppComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Hetang.Shah on 11/29/17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        TestAppBindingModule::class,
        TestAppModule::class
))
interface TestAppComponent : AppComponent {

    fun inject(app: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TestApplication): Builder

        fun build(): TestAppComponent
    }
}

@Module
class TestAppModule {
    @Provides
    @Singleton
    fun provideContext(app: TestApplication): Context = app.applicationContext
}