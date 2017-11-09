package com.fivestars.data.models

import com.fivestars.data.models.STATUS.INCOMPLETE

/**
 * Created by Hetang.Shah on 11/7/17.
 */

enum class STATUS {
    COMPLETED, INCOMPLETE, IN_PROGRESS
}

data class TaskItem(
        val item: String,
        val status: STATUS = INCOMPLETE
)