package com.gaurav.cartsystem.data.db.dao

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.data.db.entities.Item
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CartItemDao {

    @Query("SELECT * FROM cart_items")
    fun getCartItems(): DataSource.Factory<Int, CartItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartItems(vararg items: CartItem): List<Long>

    @Update
    fun updateCartItems(vararg items: CartItem)

    @Delete
    fun deleteCartItems(vararg items: CartItem)

    @Query("DELETE FROM cart_items")
    fun clearCartItems()
}