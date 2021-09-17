package ru.cybereagleowl.martianpictures

import android.app.Application

class App : Application() {
    /*
        override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
        prepareTimber()
    }

    private fun prepareTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }
     */
}