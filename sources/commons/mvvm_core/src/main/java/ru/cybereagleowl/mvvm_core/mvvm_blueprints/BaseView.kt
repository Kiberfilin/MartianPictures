package ru.cybereagleowl.mvvm_core.mvvm_blueprints

import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import timber.log.Timber

abstract class BaseView<VB : ViewBinding, VM : BaseViewModel>(
    protected val viewBinding: VB,
    protected val lifecycle: Lifecycle
) : LifecycleObserver{

    init {
        Timber.d("--*-- Init in Base View; lifecycle = $lifecycle, viewBinding = $viewBinding")
        registerObserver()
    }

    protected lateinit var viewModel: VM

    fun setProperViewModel(viewModel: VM) {
        Timber.d("--*-- setProperViewModel(viewModel: VM) ${this.javaClass.simpleName}")
        this.viewModel = viewModel
    }

    protected fun registerObserver() {
        Timber.d("--*-- fun registerObserver() ${this.javaClass.simpleName}")
        lifecycle.addObserver(this)
    }

    protected fun removeObserver() {
        Timber.d("--*-- fun removeObserver() ${this.javaClass.simpleName}")
        lifecycle.removeObserver(this)
    }
}