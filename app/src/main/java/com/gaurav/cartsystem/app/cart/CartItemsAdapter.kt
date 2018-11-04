package com.gaurav.cartsystem.app.cart

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.utils.inflateLayout
import com.gaurav.cartsystem.data.db.entities.CartItem

class CartItemsAdapter (context: Context, val onItemClick: (position: Int, cartItem: CartItem?) -> Unit): PagedListAdapter<CartItem, CartItemsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        val view = parent.context.inflateLayout(R.layout.item_cart_adapter, parent, false)
        return CartItemsViewHolder(view) {position ->
            onItemClick.invoke(position, getItem(position))
        }
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.setData(it)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object :
                DiffUtil.ItemCallback<CartItem>() {
            override fun areItemsTheSame(oldItem: CartItem,
                                         newItem: CartItem): Boolean =
                    oldItem.cartItemId == newItem.cartItemId

            override fun areContentsTheSame(oldItem: CartItem,
                                            newItem: CartItem): Boolean =
                    oldItem == newItem
        }
    }
}