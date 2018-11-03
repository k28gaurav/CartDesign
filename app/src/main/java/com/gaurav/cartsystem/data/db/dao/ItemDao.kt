package com.gaurav.cartsystem.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.gaurav.cartsystem.data.db.entities.Item
import io.reactivex.Flowable

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(items: List<Item>)

}