package com.gaurav.cartsystem.domain.interactor

import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.domain.repository.CartRepository
import javax.inject.Inject

class SaveItemsUseCase @Inject constructor(private val cartRepository: CartRepository) {
    fun execute(items: List<Item>) {
        cartRepository.saveAllItems(items)
    }
}