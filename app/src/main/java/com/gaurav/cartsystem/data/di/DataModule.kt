package com.gaurav.cartsystem.data.di

import com.gaurav.cartsystem.data.cart.CartRepositoryImpl
import com.gaurav.cartsystem.domain.repository.CartRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideCartRepository(cartRepositoryImpl: CartRepositoryImpl): CartRepository

}