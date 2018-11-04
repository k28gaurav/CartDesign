package com.gaurav.cartsystem.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int,

        @Embedded
        val item: Item,

        @ColumnInfo(name = "quantity")
        val quantity: Int
)