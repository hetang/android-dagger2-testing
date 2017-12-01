package com.fivestars.dagger2app.task.activities

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.fivestars.dagger2app.R
import com.fivestars.dagger2app.activities.TaskActivity
import com.fivestars.dagger2app.utils.RecyclerViewMatcher
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

    fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Test
    fun testSaveSuccess() {
        onView(withId(R.id.btnAdd))

        onView(withId(R.id.task_input)).perform(ViewActions.typeText("Test_Item3"),
                ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btnAdd)).perform(ViewActions.click())

        onView(withRecyclerView(R.id.task_items)
                .atPositionOnView(2, R.id.task_name))
                .check(matches(withText("Test_Item3")))
    }

    @Test
    fun taskActivityTest() {

        onView(withRecyclerView(R.id.task_items)
                .atPositionOnView(0, R.id.task_name))
                .check(matches(withText("Test_Item1")))

        onView(withRecyclerView(R.id.task_items)
                .atPositionOnView(1, R.id.task_name))
                .check(matches(withText("Test_Item2")))

    }
}