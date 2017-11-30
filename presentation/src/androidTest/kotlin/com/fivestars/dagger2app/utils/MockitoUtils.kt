package com.fivestars.dagger2app.utils

import org.mockito.*
import org.mockito.stubbing.*

/**
 * Created by Hetang.Shah on 11/29/17.
 */

fun <T> replace(methodCall: T) = Mockito.`when`(methodCall)

fun <T> replace(methodCall: T, thenReturn: () -> T) =
        Mockito.`when`(methodCall).thenReturn(thenReturn())

fun <T> OngoingStubbing<T>.with(value: T) = this.thenReturn(value)