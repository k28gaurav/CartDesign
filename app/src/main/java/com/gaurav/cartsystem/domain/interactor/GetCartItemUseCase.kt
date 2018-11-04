package com.gaurav.cartsystem.domain.interactor

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCartItemUseCase @Inject constructor(private val cartRepository: CartRepository) {

    fun execute(): LiveData<PagedList<CartItem>> {
        return cartRepository.getCartItems()
    }
}