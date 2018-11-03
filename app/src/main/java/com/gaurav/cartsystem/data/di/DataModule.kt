package com.gaurav.cartsystem.data.di

import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class DataModule {
}