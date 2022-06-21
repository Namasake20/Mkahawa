package com.namasake.mkahawa.business.data.network

import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.framework.datasource.network.mappers.NetworkMapper
import com.namasake.mkahawa.framework.datasource.network.retrofit.RestaurantRetrofitService

class NetworkDataSourceImpl(
    private val restaurantRetrofitService: RestaurantRetrofitService,
    private val networkMapper: NetworkMapper
) :NetworkDataSource {
    override suspend fun get(): List<Restaurant> {
        return networkMapper.mapFromEntityList(restaurantRetrofitService.get())
    }
}