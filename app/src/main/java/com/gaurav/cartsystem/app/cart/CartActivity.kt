package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseActivity
import javax.inject.Inject

class CartActivity : DaggerBaseActivity<CartViewModel>(), LibraryFragment.ChangeFragmentListener {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var libraryFragment: LibraryFragment
    @Inject lateinit var cartFragment: ShoppingCartFragment
    @Inject lateinit var allItemsFragment: AllItemsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CartViewModel::class.java]
        initViews()
    }

    override fun onFragmentChange(fragmentName: LibraryFragment.NextFrag) {

    }
}
