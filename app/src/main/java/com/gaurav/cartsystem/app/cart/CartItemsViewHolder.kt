package com.gaurav.cartsystem.app.cart

import android.view.View
import com.gaurav.cartsystem.app.base.BaseViewHolder
import com.gaurav.cartsystem.data.db.entities.CartItem
import kotlinx.android.synthetic.main.item_cart_adapter.view.*
import java.text.DecimalFormat

class CartItemsViewHolder (val view: View, onItemClick: (position: Int) -> Unit): BaseViewHolder<CartItem>(view) {

    init {
        onItemClick.invoke(adapterPosition)
    }

    override fun setData(data: CartItem) {
        view.tv_cart_item_name.text = data.item.title
        view.tv_cart_item_quantity.text = String.format("x%d", data.quantity)
        val decimalFormat = DecimalFormat("#,###,##0.00")
        view.tv_cart_item_price.text = "$ ${decimalFormat.format(data.item.price)}"
    }

}