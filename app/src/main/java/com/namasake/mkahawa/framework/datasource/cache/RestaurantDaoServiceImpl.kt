package com.namasake.mkahawa.framework.datasource.cache

import com.namasake.mkahawa.framework.datasource.cache.database.RestaurantDao
import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity

class RestaurantDaoServiceImpl
constructor(private val restaurantDao: RestaurantDao):RestaurantDaoService {
    override suspend fun insert(restaurantCacheEntity: RestaurantCacheEntity): Long {
        return restaurantDao.insert(restaurantCacheEntity)
    }

    override suspend fun get(): List<RestaurantCacheEntity> {
        return restaurantDao.get()
    }


}