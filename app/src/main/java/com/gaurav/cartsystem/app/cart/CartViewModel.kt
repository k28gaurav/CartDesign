package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.MutableLiveData
import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.data.cart.service.CartApiService
import javax.inject.Inject

class CartViewModel @Inject constructor(schedulersFacade: SchedulersFacade): BaseViewModel(schedulersFacade)
