package com.gaurav.cartsystem.data.cart

import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single

class CartRepositoryImpl: CartRepository {
    fun fetchAllItems(): Single<List<It>>
}