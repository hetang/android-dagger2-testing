package com.fivestars.domain.usecases

import io.reactivex.Observable

/**
 * Created by Hetang.Shah on 11/8/17.
 */
interface BaseUseCase<T> {
    fun execute(): Observable<T>
}