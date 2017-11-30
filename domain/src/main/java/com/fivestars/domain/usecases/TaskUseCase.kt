package com.fivestars.domain.usecases

import android.content.Context
import android.util.Log
import com.fivestars.data.models.TaskItem
import com.fivestars.data.utils.addTask
import com.fivestars.data.utils.getTask
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Hetang.Shah on 11/7/17.
 */
open class AddTaskUseCase(private val context: Context?) : BaseUseCase<Unit> {
    lateinit var task: TaskItem

    fun addParameters(task: TaskItem) {
        this.task = task
    }

    override fun execute(): Observable<Unit> {
        return Observable.create { subscriber: ObservableEmitter<Unit> ->
            context?.addTask(task)
            subscriber.onNext(Unit)
            subscriber.onComplete()
        }
                .doOnError { throwable ->
                    Log.e(this.javaClass.simpleName, "Error while adding task: ", throwable)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}

open class GetTaskUseCase(private val context: Context?) : BaseUseCase<List<TaskItem>> {
    override fun execute(): Observable<List<TaskItem>> {
        return Observable.create { subscriber: ObservableEmitter<List<TaskItem>> ->
            subscriber.onNext(context?.getTask() ?: mutableListOf())
            subscriber.onComplete()
        }
                .doOnError { throwable ->
                    Log.e(this.javaClass.simpleName, "Error while getting task: ", throwable)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}