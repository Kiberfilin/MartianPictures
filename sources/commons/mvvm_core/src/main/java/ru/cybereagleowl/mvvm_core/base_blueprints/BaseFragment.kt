package ru.cybereagleowl.mvvm_core.base_blueprints

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import ru.cybereagleowl.mvvm_core.mvvm_blueprints.BaseView
import ru.cybereagleowl.mvvm_core.mvvm_blueprints.BaseViewModel
import ru.cybereagleowl.mvvm_core.mvvm_blueprints.MvvmContract.*
import timber.log.Timber

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel, VMF : ViewModelProvider.Factory, V : MvvmView> :
    Fragment() {
    abstract var viewModelFactory: VMF
    protected lateinit var viewModel: VM

    abstract var view: V
    private var _binding: VB? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    protected val binding
        get() = _binding
            ?: throw NullPointerException("The private var _binding: VB? equals null in ${this::class.simpleName}")

    protected fun initViewBinding(viewBinding: VB) {
        _binding = viewBinding
    }

    protected fun createAndSetViewModel(javaClass: Class<VM>) {
        Timber.d("--*-- createAndSetViewModel(javaClass: Class<VM>)")
        viewModel = ViewModelProvider(this, viewModelFactory).get(javaClass)
        viewModel.setNavControllerToVIewModel(this.findNavController())
        @Suppress("UNCHECKED_CAST")
        (view as BaseView<VB, VM>).setProperViewModel(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onDestroying()
        _binding = null
    }
}