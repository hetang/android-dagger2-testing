package com.fivestars.dagger2app.activities.dagger

import com.fivestars.dagger2app.activities.TaskActivity
import com.fivestars.dagger2app.activities.TaskView
import dagger.Binds
import dagger.Module

/**
 * Created by Hetang.Shah on 11/29/17.
 */
@Module
abstract class TaskModule {

    @Binds abstract fun provideTaskView(activity: TaskActivity): TaskView
}

//@Module
//open class TaskViewModule {
//
//    //Need to do @Provides here because the @Binds way of doing things doesn't play nice with
//    // generics and presenter construction injection will not correctly cast the type of the
//    // corresponding activity to match its expected ExpandedCardView
//    @Provides
//    fun provideTaskPresenter(activity: TaskActivity): TaskPresenter<TaskItem> {
//        return TaskPresenter<TaskItem>(activity)
//    }
//}