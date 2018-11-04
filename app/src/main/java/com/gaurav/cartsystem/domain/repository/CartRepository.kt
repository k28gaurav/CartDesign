package com.gaurav.cartsystem.domain.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.data.db.entities.Item
import io.reactivex.Single

interface CartRepository {
    fun getItems(): LiveData<PagedList<Item>>

    fun saveCartItem(cartItem: CartItem):Single<List<Long>>

    fun updateCartItem(cartItem: CartItem)

    fun deleteCartItem(cartItem: CartItem)

    fun getCartItems(): LiveData<PagedList<CartItem>>

    fun fetchItems(): Single<List<Item>>

    fun saveAllItems(items: List<Item>)

    fun clearCart(): Single<Any>
}