package com.gaurav.cartsystem.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.gaurav.cartsystem.app.utils.Constants
import com.gaurav.cartsystem.data.db.CartDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideCartDatabase(context: Context): CartDatabase {
        return Room.databaseBuilder(context.applicationContext,
                CartDatabase::class.java,
                Constants.DB_NAME).build()
    }
}