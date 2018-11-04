package com.gaurav.cartsystem.app.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gaurav.cartsystem.app.cart.AllItemsViewModel
import com.gaurav.cartsystem.app.cart.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun cartViewModel(viewModel: CartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllItemsViewModel::class)
    abstract fun allItemsViewModel(viewModel: AllItemsViewModel): ViewModel

}