package com.gaurav.cartsystem.app.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseFragment
import javax.inject.Inject

class ShoppingCartFragment @Inject constructor(): DaggerBaseFragment<ShoppingCartViewModel>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }


    override fun initEventHandlers() {

    }

    override fun onClick(view: View?) {
        when(view?.id) {

        }
    }
}