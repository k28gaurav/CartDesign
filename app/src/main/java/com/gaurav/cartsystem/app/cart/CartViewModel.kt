package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.MutableLiveData
import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.data.cart.service.CartApiService
import com.gaurav.cartsystem.data.db.entities.CartItem
import com.gaurav.cartsystem.domain.interactor.AddCartItemUseCase
import javax.inject.Inject

class CartViewModel @Inject constructor(schedulersFacade: SchedulersFacade, private val addCartItemUseCase: AddCartItemUseCase): BaseViewModel(schedulersFacade) {
    fun saveCartItem(cartItem: CartItem) {
        addCartItemUseCase.execute(cartItem)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe({

                }, {

                })
    }
}