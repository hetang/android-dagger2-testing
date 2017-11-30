package com.fivestars.dagger2app.common.dagger

import android.content.Context
import com.fivestars.dagger2app.Dagger2Application
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
        AppBindingModule::class,
        AppModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Dagger2Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: Dagger2Application)
}


@Module
open class AppModule {
    @Provides
    @Singleton open fun provideContext(app: Dagger2Application): Context {
        return app.applicationContext
    }
}