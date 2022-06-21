package com.namasake.mkahawa.business.data.cache

import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.framework.datasource.cache.RestaurantDaoService
import com.namasake.mkahawa.framework.datasource.cache.mappers.CacheMapper
import javax.inject.Inject

class CacheDataSourceImpl @Inject constructor(
    private val restaurantDaoService: RestaurantDaoService,
    private val cacheMapper: CacheMapper
) :CacheDataSource{
    override suspend fun insert(restaurant: Restaurant): Long {
        return restaurantDaoService.insert(cacheMapper.mapToEntity(restaurant))
    }

    override suspend fun insertList(restaurant: List<Restaurant>) {
        for (rest in restaurant){
            restaurantDaoService.insert(cacheMapper.mapToEntity(rest))
        }
    }

    override suspend fun get(): List<Restaurant> {
        return cacheMapper.mapFromEntityList(restaurantDaoService.get())
    }
}