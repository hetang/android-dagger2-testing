package com.fivestars.domain.dagger.modules

import android.content.Context
import com.fivestars.domain.usecases.AddTaskUseCase
import com.fivestars.domain.usecases.GetTaskUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Hetang.Shah on 11/29/17.
 */

@Module open class TaskUseCaseModule {
    @Provides open fun providesAddTaskUseCase(
            context: Context): AddTaskUseCase {
        return AddTaskUseCase(context)
    }

    @Provides open fun providesGetTaskUseCase(
            context: Context): GetTaskUseCase {
        return GetTaskUseCase(context)
    }
}