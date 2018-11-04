package com.gaurav.cartsystem.app.cart

import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.domain.interactor.ClearCartItemUseCase
import com.gaurav.cartsystem.domain.interactor.GetCartItemUseCase
import javax.inject.Inject

class ShoppingCartViewModel @Inject constructor(schedulersFacade: SchedulersFacade,
                                                private val getCartItemsUseCase: GetCartItemUseCase,
                                                private val clearCartItemUseCase: ClearCartItemUseCase): BaseViewModel(schedulersFacade) {
    fun clearCartItems() {
        clearCartItemUseCase.execute()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe({_ ->

                }, { _ ->

                })

    }


    val cartItemsLiveData = getCartItemsUseCase.execute()

}