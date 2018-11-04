package com.gaurav.cartsystem.domain.interactor

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.gaurav.cartsystem.data.db.entities.Item
import com.gaurav.cartsystem.domain.repository.CartRepository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(private val cartRepository: CartRepository){
    fun execute(): LiveData<PagedList<Item>> {
        return cartRepository.getItems()
    }
}