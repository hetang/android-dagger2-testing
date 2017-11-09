package com.fivestars.dagger2app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fivestars.dagger2app.R
import com.fivestars.data.models.TaskItem
import kotlinx.android.synthetic.main.task_list_item.view.task_name
import kotlinx.android.synthetic.main.task_list_item.view.task_status

/**
 * Created by Hetang.Shah on 11/6/17.
 */
class AddTaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    var dataSet: MutableList<TaskItem> = mutableListOf()

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = dataSet[position]
        holder.apply {
            taskText.text = task.item
            taskStatus.text = task.status.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    fun add(item: TaskItem) {
        dataSet.add(item)
        this.notifyDataSetChanged()
    }

    fun addAll(item: List<TaskItem>) {
        dataSet.addAll(item)
        this.notifyDataSetChanged()
    }
}

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val taskText = view.task_name
    val taskStatus = view.task_status
}