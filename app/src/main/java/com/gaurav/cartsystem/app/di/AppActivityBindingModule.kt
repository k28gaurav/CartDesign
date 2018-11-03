package com.gaurav.cartsystem.app.di

import com.gaurav.cartsystem.app.cart.CartActivity
import com.gaurav.cartsystem.app.cart.CartModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [CartModule::class])
    abstract fun cartActivity(): CartActivity
}