package com.gaurav.cartsystem.app.di

import android.app.Application
import com.gaurav.cartsystem.CartApplication
import com.gaurav.cartsystem.app.common.ViewModelModule
import com.gaurav.cartsystem.data.di.DataModule
import com.gaurav.cartsystem.data.di.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
                      AndroidSupportInjectionModule::class,
                      ViewModelModule::class,
                      DataModule::class,
                      AndroidInjectionModule::class,
                      AppActivityBindingModule::class])
interface AppComponent: AndroidInjector<CartApplication>{
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}