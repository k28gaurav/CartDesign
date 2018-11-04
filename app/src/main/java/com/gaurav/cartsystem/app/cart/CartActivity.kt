package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseActivity
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.data.models.DiscountItem
import kotlinx.android.synthetic.main.activity_cart.fl_cart_container
import kotlinx.android.synthetic.main.activity_cart.fl_library_container
import javax.inject.Inject

class CartActivity : DaggerBaseActivity<CartViewModel>(), LibraryFragment.ChangeFragmentListener,
        AllItemsFragment.ShowAddItemToCartDialogListener, AddItemToCartFragment.ShowAddItemToCartDialogListener,
        ShoppingCartFragment.ShowEditItemToCartDialogListener, DiscountFragment.OnClickDiscountItems{



    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var libraryFragment: LibraryFragment
    @Inject lateinit var cartFragment: ShoppingCartFragment
    @Inject lateinit var allItemsFragment: AllItemsFragment
    @Inject lateinit var discountFragment: DiscountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CartViewModel::class.java]
        initViews()
    }

    override fun initViews() {
        supportFragmentManager?.beginTransaction()
                ?.replace(fl_library_container.id, libraryFragment, "library")
                ?.replace(fl_cart_container.id, cartFragment, "cart")
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

            LibraryFragment.NextFrag.ALL_DISCOUNT -> {
                    supportFragmentManager?.beginTransaction()
                            ?.replace(fl_library_container.id, discountFragment, "discountItems")
                            ?.commit()
            }
        }
    }

    override fun saveCartItem(cartItem: CartItem) {
        viewModel.saveCartItem(cartItem)
    }

    override fun onShowAddItemToCartDialog(item: Item) {

        AddItemToCartFragment.getInstance(false, item, null).show(supportFragmentManager, "")

    }

    override fun onShowEditItemToCartDialog(item: CartItem) {
        AddItemToCartFragment.getInstance(true, null, item).show(supportFragmentManager, "")

    }

    override fun addDiscountToCart(item: DiscountItem) {

    }

}
