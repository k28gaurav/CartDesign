package com.gaurav.cartsystem.app.base

interface AdapterItemClick<T> {

    fun onItemClick(viewType: Int, data:T)
}