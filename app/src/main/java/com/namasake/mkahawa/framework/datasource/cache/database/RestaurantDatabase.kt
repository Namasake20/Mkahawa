package com.namasake.mkahawa.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity

@Database(entities = [RestaurantCacheEntity::class], version = 1)
abstract class RestaurantDatabase: RoomDatabase() {

    abstract fun restaurantDao():RestaurantDao

    companion object{
        val DATABASE_NAME = "restaurant_db"
    }
}