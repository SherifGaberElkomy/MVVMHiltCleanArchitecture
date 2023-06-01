package com.example.mvvmhiltcleanarchitecture.domaiin.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {
    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable by lazy { CompositeDisposable() }

    fun disposeLast() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}