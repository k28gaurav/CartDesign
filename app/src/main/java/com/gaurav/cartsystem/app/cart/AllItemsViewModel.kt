package com.gaurav.cartsystem.app.cart

import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.domain.interactor.FetchItemListUseCase
import com.gaurav.cartsystem.domain.interactor.GetItemsUseCase
import com.gaurav.cartsystem.domain.interactor.SaveItemsUseCase
import timber.log.Timber
import javax.inject.Inject

class AllItemsViewModel @Inject constructor(schedulersFacade: SchedulersFacade,
                                            getItemsUseCase: GetItemsUseCase,
                                            private val fetchItemListUseCase: FetchItemListUseCase,
                                            private val saveItemsUseCase: SaveItemsUseCase):
        BaseViewModel(schedulersFacade) {

    val itemsLiveData = getItemsUseCase.execute()
    fun fetchItemList() {
        val fetchItemListDisposal = fetchItemListUseCase.execute()
                .subscribeOn(schedulers.io())
                .map { items ->
                    items.forEach { item ->
                        item.price = (item.id * Math.random() * 89 + 10)
                    }
                    saveItemsUseCase.execute(items)
                }
                .observeOn(schedulers.ui())
                .subscribe({

                }, { err ->
                    Timber.e(err)
                    //TODO: Show error  toast and stop loading
                })

        getCompositeDisposable().add(fetchItemListDisposal)
    }
}