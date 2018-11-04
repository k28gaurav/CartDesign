package com.gaurav.cartsystem.app.cart

import com.gaurav.cartsystem.app.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CartModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun libraryFragment(): LibraryFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun shoppingCartFragment(): ShoppingCartFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun allItemsFragment(): AllItemsFragment
}