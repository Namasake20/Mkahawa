package com.namasake.mkahawa.framework.datasource.network.retrofit

import com.namasake.mkahawa.framework.datasource.network.model.RestaurantNetworkEntity

interface RestaurantRetrofitService {
    suspend fun get():List<RestaurantNetworkEntity>
}