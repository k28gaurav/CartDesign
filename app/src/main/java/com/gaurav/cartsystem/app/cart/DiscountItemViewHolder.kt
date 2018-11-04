package com.gaurav.cartsystem.app.cart

import android.view.View
import com.gaurav.cartsystem.app.base.BaseViewHolder
import com.gaurav.cartsystem.data.models.DiscountItem
import kotlinx.android.synthetic.main.item_discount.view.tv_discount_item_name
import kotlinx.android.synthetic.main.item_discount.view.tv_discount_value
import timber.log.Timber

class DiscountItemViewHolder (val view: View, val onItemClick: (position: Int) -> Unit): BaseViewHolder<DiscountItem>(view) {

    init {
        view.setOnClickListener {
           onItemClick.invoke(adapterPosition)
        }
    }


    override fun setData(data: DiscountItem) {
        view.tv_discount_item_name.text = data.title
        view.tv_discount_value.text = "${data.discountValue}"
    }

}