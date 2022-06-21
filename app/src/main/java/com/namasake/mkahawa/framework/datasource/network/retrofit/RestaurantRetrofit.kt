package com.namasake.mkahawa.framework.datasource.network.retrofit

import com.namasake.mkahawa.framework.datasource.network.model.RestaurantNetworkEntity
import retrofit2.http.GET

interface RestaurantRetrofit {

    companion object{
        const val BASE_URL = " https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun get():List<RestaurantNetworkEntity>
}