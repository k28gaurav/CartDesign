package com.gaurav.cartsystem.app.cart

import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import javax.inject.Inject

class AllItemsViewModel @Inject constructor(schedulersFacade: SchedulersFacade):
        BaseViewModel(schedulersFacade) {
}