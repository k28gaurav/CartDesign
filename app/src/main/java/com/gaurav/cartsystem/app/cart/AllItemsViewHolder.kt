package com.gaurav.cartsystem.app.cart

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gaurav.cartsystem.app.base.BaseViewHolder
import com.gaurav.cartsystem.data.db.entities.Item
import kotlinx.android.synthetic.main.all_item_adapter.view.iv_item
import kotlinx.android.synthetic.main.all_item_adapter.view.tv_item_name
import kotlinx.android.synthetic.main.all_item_adapter.view.tv_item_price
import java.text.DecimalFormat

class AllItemsViewHolder(val view: View, val onClick : (position:Int) -> Unit): BaseViewHolder<Item>(view) {

    init {
        view.setOnClickListener {
            onClick.invoke(adapterPosition)
        }
    }

    override fun setData(data: Item) {
        view.tv_item_name.text = data.title
        Glide.with(view.context)
                .load(data.thumbnailUrl)
                .apply(RequestOptions().centerCrop())
                .into(view.iv_item)
        val decimalFormat = DecimalFormat("#,###,##0.00")
        view.tv_item_price.text = "$ ${decimalFormat.format(data.price)}"
    }
}