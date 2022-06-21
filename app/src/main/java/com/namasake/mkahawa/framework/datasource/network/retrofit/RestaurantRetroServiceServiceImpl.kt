package com.namasake.mkahawa.framework.datasource.network.retrofit

import com.namasake.mkahawa.framework.datasource.network.model.RestaurantNetworkEntity

class RestaurantRetroServiceServiceImpl
constructor(private val restaurantRetrofit: RestaurantRetrofit) :RestaurantRetrofitService {
    override suspend fun get(): List<RestaurantNetworkEntity> {
        return restaurantRetrofit.get()
    }
}