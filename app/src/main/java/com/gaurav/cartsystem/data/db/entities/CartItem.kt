package com.gaurav.cartsystem.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name="item_id")
        val itemId:Int,
        @ColumnInfo(name="itema_name")
        val itemName: String,
        @ColumnInfo(name = "count")
        var totalItemCount: Int,
        @ColumnInfo(name= "price")
        var itemPrice: Float,
        @ColumnInfo(name= "discount")
        var itemDiscountValue: Int,
        @ColumnInfo(name="is_selected")
        var isSelected: Boolean
)