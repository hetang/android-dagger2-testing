package com.fivestars.dagger2app.utils

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.*

/**
 * From https://gist.github.com/baconpat/8405a88d04bd1942eb5e430d33e4faa2 converted to kotlin
 * which is forked from of https://github.com/dannyroa/espresso-samples
 */
class RecyclerViewMatcher(private val recyclerViewId: Int) {

    fun atPosition(position: Int): Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() { //anonymous class
            internal var resources: Resources? = null
            internal var childView: View? = null

            override fun describeTo(description: Description) {
                var idDescription = Integer.toString(recyclerViewId)
                if (this.resources != null) {
                    try {
                        idDescription = this.resources!!.getResourceName(recyclerViewId)
                    } catch (error: Resources.NotFoundException) {
                        idDescription = String.format("%s (resource name not found)", recyclerViewId)
                    }

                }

                description.appendText("RecyclerView with id: $idDescription at position: $position")
            }

            public override fun matchesSafely(view: View): Boolean {

                this.resources = view.resources

                if (childView == null) {
                    val recyclerView = view.rootView.findViewById<View>(recyclerViewId) as RecyclerView?
                    if (recyclerView?.id == recyclerViewId) {
                        val viewHolder = recyclerView
                                .findViewHolderForAdapterPosition(position)
                        childView = viewHolder?.itemView
                    } else {
                        return false
                    }
                }

                if (targetViewId == -1) {
                    return view === childView
                } else {
                    val targetView = childView!!.findViewById<View>(targetViewId)
                    return view === targetView
                }
            }
        }
    }
}