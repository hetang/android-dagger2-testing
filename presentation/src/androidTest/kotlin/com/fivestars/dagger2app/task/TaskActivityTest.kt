package com.fivestars.dagger2app.task

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.fivestars.dagger2app.activities.TaskActivity
import org.junit.*
import org.junit.runner.*


/**
 * Created by Hetang.Shah on 11/29/17.
 */

@RunWith(AndroidJUnit4::class)
class TaskActivityTest {

    @Rule
    @JvmField
    public var mActivityRule: ActivityTestRule<TaskActivity> = ActivityTestRule(TaskActivity::class.java)

    @Test
    fun testSaveSuccess() {

    }

    @Test
    fun testGetSuccess() {

    }
}