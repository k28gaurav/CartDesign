package com.gaurav.cartsystem.data.cart.service

import com.gaurav.cartsystem.data.db.entities.Item
import io.reactivex.Single
import retrofit2.http.GET

interface CartApiService {

    @GET("/photos")
    fun getAllItems(): Single<List<Item>>
}