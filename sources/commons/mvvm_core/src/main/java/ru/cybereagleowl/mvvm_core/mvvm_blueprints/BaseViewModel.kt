package ru.cybereagleowl.mvvm_core.mvvm_blueprints

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import androidx.navigation.NavController
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    protected var navController: NavController? = null
    fun setNavControllerToVIewModel(navController: NavController) {
        this.navController = navController
    }

    fun onDestroying() {
        navController = null
    }

    override fun onCleared() {
        Timber.d("--*-- onCleared() ${this.javaClass.simpleName}")
        compositeDisposable.dispose()
        super.onCleared()
    }
}