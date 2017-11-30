package com.fivestars.dagger2app.task.dagger

import android.content.Context
import com.fivestars.dagger2app.activities.TaskActivity
import com.fivestars.dagger2app.activities.TaskView
import com.fivestars.dagger2app.utils.replace
import com.fivestars.dagger2app.utils.with
import com.fivestars.data.models.TaskItem
import com.fivestars.domain.usecases.AddTaskUseCase
import com.fivestars.domain.usecases.GetTaskUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import org.mockito.*

/**
 * Created by Hetang.Shah on 11/29/17.
 */

@Module
abstract class TestTaskModule {
    @Binds abstract fun provideTaskView(activity: TaskActivity): TaskView
}

@Module open class TestTaskUseCaseModule {
    val mockItems = mutableListOf<TaskItem>(TaskItem("Test_Item1"), TaskItem("Test_Item2"))

    @Provides open fun providesAddTaskUseCase(
            context: Context): AddTaskUseCase {

        val mock = Mockito.mock(AddTaskUseCase::class.java)

        replace(mock.execute()).thenAnswer {
            mockItems.add(mock.task)
        }.with(Observable.just(Unit))

        return mock
    }

    @Provides open fun providesGetTaskUseCase(
            context: Context): GetTaskUseCase {

        val mock = Mockito.mock(GetTaskUseCase::class.java)

        replace(mock.execute()).with(Observable.just(mockItems.toList()))
        return mock
    }
}