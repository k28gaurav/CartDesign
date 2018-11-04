package com.gaurav.cartsystem.app.cart

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.utils.inflateLayout
import com.gaurav.cartsystem.data.models.DiscountItem

class DiscountItemsAdapter(val context: Context, val onItemClick: (position: Int, discountItem: DiscountItem) -> Unit) : RecyclerView.Adapter<DiscountItemViewHolder>(){

    var discountItems = mutableListOf<DiscountItem>()
      set(value) {
          field.clear()
          field.addAll(value)
          notifyDataSetChanged()
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountItemViewHolder {
        val view = parent.context.inflateLayout(R.layout.item_discount, parent, false)
        return DiscountItemViewHolder(view) { position ->
            val item = discountItems[position]
            item?.let {
                onItemClick.invoke(position, it)
            }

        }
    }

    override fun getItemCount(): Int {
        return discountItems.size
    }

    override fun onBindViewHolder(holder: DiscountItemViewHolder, position: Int) {
        val item = discountItems[position]
        item?.let {
            holder.setData(it)
        }
    }
}