package com.gaurav.cartsystem.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cart_items", indices = [Index(value = ["id", "discount"], unique = true)])
data class CartItem(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "cart_id")
        val cartItemId: Int?,

        @Embedded
        val item: Item,

        @ColumnInfo(name = "quantity")
        var quantity: Int,

        @ColumnInfo(name = "discount")
        var discount: Float
): Parcelable