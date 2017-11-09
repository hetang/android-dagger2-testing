package com.fivestars.dagger2app.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.fivestars.dagger2app.R
import com.fivestars.dagger2app.adapter.AddTaskAdapter
import com.fivestars.dagger2app.presenters.TaskPresenter
import com.fivestars.data.models.TaskItem
import kotlinx.android.synthetic.main.activity_add_task.btnAdd
import kotlinx.android.synthetic.main.activity_add_task.task_container
import kotlinx.android.synthetic.main.activity_add_task.task_input
import kotlinx.android.synthetic.main.activity_add_task.task_items

interface TaskView {
    fun onSaveCompleted(task: TaskItem)
    fun onError()
    fun showTasks(tasks: List<TaskItem>)
}

class TaskActivity : AppCompatActivity(), TaskView {
    val taskAdapter = AddTaskAdapter()
    val taskPresenter = TaskPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        task_items.layoutManager = LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false)
        task_items.adapter = taskAdapter
        btnAdd.setOnClickListener({
            addTodoItem()
        })

        taskPresenter.getTask()
    }

    private fun addTodoItem() {
        val item = task_input.text.toString()
        taskPresenter.saveTask(item)
    }

    override fun onSaveCompleted(task: TaskItem) {
        taskAdapter.add(task)
        task_input.setText("")
    }

    override fun onError() {
        Snackbar.make(task_container, "Error while saving Task", Snackbar.LENGTH_LONG)
                .show()
    }

    override fun showTasks(tasks: List<TaskItem>) {
        taskAdapter.addAll(tasks)
    }
}
