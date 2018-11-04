package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseActivity
import com.gaurav.cartsystem.data.db.entities.Item
import kotlinx.android.synthetic.main.activity_cart.fl_cart_container
import kotlinx.android.synthetic.main.activity_cart.fl_library_container
import javax.inject.Inject

class CartActivity : DaggerBaseActivity<CartViewModel>(), LibraryFragment.ChangeFragmentListener,
        AllItemsFragment.ShowAddItemToCartDialogListener{


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

    override fun initViews() {
        supportFragmentManager?.beginTransaction()
                ?.add(fl_library_container.id, libraryFragment, "library")
                ?.add(fl_cart_container.id, cartFragment, "cart")
                ?.commit()
        super.initViews()
    }

    override fun onFragmentChange(fragmentName: LibraryFragment.NextFrag) {
        when(fragmentName) {
            LibraryFragment.NextFrag.ALL_ITEMS -> {
                supportFragmentManager?.beginTransaction()
                        ?.replace(fl_library_container.id, allItemsFragment, "allItems")
                        ?.commit()
            }
            else -> {}
        }
    }

    override fun onShowAddItemToCartDialog(item: Item) {
    }
}
