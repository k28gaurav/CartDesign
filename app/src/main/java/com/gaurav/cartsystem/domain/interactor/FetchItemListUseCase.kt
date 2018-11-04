package com.gaurav.cartsystem.domain.interactor

import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.domain.repository.CartRepository
import io.reactivex.Single
import javax.inject.Inject

class FetchItemListUseCase @Inject constructor(private val cartRepository: CartRepository) {
    fun execute(): Single<List<Item>> {
        return cartRepository.fetchItems()
    }
}