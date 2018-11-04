package com.gaurav.cartsystem.app.cart

import android.view.View
import com.gaurav.cartsystem.app.base.BaseViewHolder
import com.gaurav.cartsystem.data.db.entities.Item
import kotlinx.android.synthetic.main.item_cart.view.tv_item_name

class AllItemsViewHolder(val view: View, val onClick : (position:Int) -> Unit): BaseViewHolder<Item>(view) {

    init {
        view.setOnClickListener {
            onClick.invoke(adapterPosition)
        }
    }

    override fun setData(data: Item) {
        view.tv_item_name.text = data.title
    }
}