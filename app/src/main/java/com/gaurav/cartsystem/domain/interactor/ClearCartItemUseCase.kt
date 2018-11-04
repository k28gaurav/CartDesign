package com.gaurav.cartsystem.domain.interactor

import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single
import javax.inject.Inject

class ClearCartItemUseCase @Inject constructor(private val repository: CartRepository) {
    fun execute(): Single<Any> {
        return repository.clearCart()
    }
}