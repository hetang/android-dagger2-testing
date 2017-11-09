package com.fivestars.dagger2app.presenters

import android.util.Log
import com.fivestars.dagger2app.Dagger2Application
import com.fivestars.dagger2app.activities.TaskView
import com.fivestars.data.models.TaskItem
import com.fivestars.domain.usecases.AddTaskUseCase
import com.fivestars.domain.usecases.GetTaskUseCase

/**
 * Created by Hetang.Shah on 11/7/17.
 */
class TaskPresenter(private val view: TaskView? = null) {
    private val addTaskUseCase = AddTaskUseCase(Dagger2Application.context)
    private val getTaskUseCase = GetTaskUseCase(Dagger2Application.context)

    fun saveTask(taskName: String) {
        val task = TaskItem(taskName)
        addTaskUseCase.addParameters(task)

        addTaskUseCase.execute().subscribe(
                {
                    view?.onSaveCompleted(task)
                },
                { error ->
                    Log.e(javaClass.simpleName, "Error while saving task", error)
                    view?.onError()
                })
    }

    fun getTask() {
        getTaskUseCase.execute().subscribe(
                { response ->
                    view?.showTasks(response)
                },
                { error ->
                    Log.e(javaClass.simpleName, "Error while getting task", error)
                    view?.onError()
                })
    }
}