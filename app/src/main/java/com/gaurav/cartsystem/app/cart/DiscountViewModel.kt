package com.gaurav.cartsystem.app.cart

import com.gaurav.cartsystem.app.base.BaseViewModel
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import com.gaurav.cartsystem.data.models.DiscountItem

import javax.inject.Inject

class DiscountViewModel @Inject constructor(schedulersFacade: SchedulersFacade):
        BaseViewModel(schedulersFacade) {

    fun getDiscountList():MutableList<DiscountItem> {
        val discountList = mutableListOf<DiscountItem>()
        discountList.add(DiscountItem("Discount A", 0.0))
        discountList.add(DiscountItem("Discount B", 10.0))
        discountList.add(DiscountItem("Discount C", 35.5))
        discountList.add(DiscountItem("Discount D", 50.0))
        discountList.add(DiscountItem("Discount E", 100.0))

        return discountList
    }
}