package com.fivestars.data.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.fivestars.data.Constants.DataConstants.PREFS_BUNDLE_NAME
import com.fivestars.data.Constants.DataConstants.TASK_INFO_KEY
import com.fivestars.data.models.TaskItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Hetang.Shah on 11/8/17.
 */
inline fun SharedPreferences.transaction(transaction: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.transaction()
    editor.apply()
}

fun Context.addTask(task: TaskItem) {
    val prefs = getSharedPreferences(PREFS_BUNDLE_NAME, MODE_PRIVATE)
    val tasks = getTask()
    tasks.add(task)
    prefs.transaction {
        putString(TASK_INFO_KEY, Gson().toJson(tasks))
    }
}

fun Context.getTask(): MutableList<TaskItem> {
    val prefs = getSharedPreferences(PREFS_BUNDLE_NAME, MODE_PRIVATE)
    val tasksString = prefs.getString(TASK_INFO_KEY, null) ?: return mutableListOf()
    val type = object : TypeToken<List<TaskItem>>() {}.type
    return Gson().fromJson(tasksString, type)
}