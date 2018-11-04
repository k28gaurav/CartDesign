package com.gaurav.cartsystem.data.cart

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.data.cart.service.CartApiService
import com.gaurav.cartsystem.data.db.CartDatabase
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val cartDatabase: CartDatabase,
                                             private val cartApiService: CartApiService,
                                             private val schedulersFacade: SchedulersFacade): CartRepository {

    override fun saveAllItems(items: List<Item>) {
        cartDatabase.itemDao().insertItems(items)
    }

    override fun getItems(): LiveData<PagedList<Item>> {
        return LivePagedListBuilder(cartDatabase.itemDao().getItems(), 20).build()
    }

    override fun fetchItems(): Single<List<Item>> {
        return cartApiService.getAllItems()
    }

    override fun saveCartItem(cartItem: CartItem): Single<List<Long>> {
        return Single.create<List<Long>> { subscriber ->
            val res = cartDatabase.cartItemDao().insertCartItems(cartItem)
            subscriber.onSuccess(res)
        }

    }

    override fun updateCartItem(cartItem: CartItem) {

    }

    override fun deleteCartItem(cartItem: CartItem) {
    }

    override fun getCartItems(): LiveData<PagedList<CartItem>> {
        return LivePagedListBuilder(cartDatabase.cartItemDao().getCartItems(), 20).build()
    }

    override fun clearCart(): Single<Any> {
        return Single.create<Any> { subscriber ->
            val res = cartDatabase.cartItemDao().clearCartItems()
            subscriber.onSuccess("lol")
        }
    }
}