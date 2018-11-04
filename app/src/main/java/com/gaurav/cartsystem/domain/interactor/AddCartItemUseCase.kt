package com.gaurav.cartsystem.domain.interactor

import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single
import javax.inject.Inject

class AddCartItemUseCase @Inject constructor(private val cartRepository: CartRepository) {

    fun execute(cartItem: CartItem): Single<List<Long>> {
        return cartRepository.saveCartItem(cartItem)
    }
}