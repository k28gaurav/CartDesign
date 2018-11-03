package com.gaurav.cartsystem.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.gaurav.cartsystem.data.db.dao.ItemDao
import com.gaurav.cartsystem.data.db.entities.Item

@Database(entities = [Item::class], version = 1)
abstract class CartDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}