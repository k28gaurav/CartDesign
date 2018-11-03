package com.gaurav.cartsystem

import com.facebook.stetho.Stetho
import com.gaurav.cartsystem.app.di.AppComponent
import com.gaurav.cartsystem.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class CartApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent
        private set

    companion object {
        lateinit var app: CartApplication
            internal set
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent =  DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
}