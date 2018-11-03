package com.gaurav.cartsystem.app.di

import android.app.Application
import android.content.Context
import com.gaurav.cartsystem.app.rx.SchedulerProvider
import com.gaurav.cartsystem.app.rx.SchedulersFacade
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(appliction: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulerProvider
}