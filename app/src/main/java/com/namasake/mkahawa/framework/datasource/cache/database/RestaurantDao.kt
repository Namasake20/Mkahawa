package com.namasake.mkahawa.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurantCacheEntity: RestaurantCacheEntity):Long

    @Query("SELECT * FROM restaurant")
    suspend fun get():List<RestaurantCacheEntity>

    @Query("DELETE FROM restaurant")
    suspend fun deleteAllRestaurants()
}