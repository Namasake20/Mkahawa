package com.namasake.mkahawa.framework.datasource.cache

import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity

interface RestaurantDaoService {
    suspend fun insert(restaurantCacheEntity: RestaurantCacheEntity): Long

    suspend fun get(): List<RestaurantCacheEntity>

}