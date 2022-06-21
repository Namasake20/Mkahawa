package com.namasake.mkahawa.business.data.cache

import com.namasake.mkahawa.business.domain.model.Restaurant

interface CacheDataSource {
    suspend fun insert(restaurant: Restaurant): Long

    suspend fun insertList(restaurant: List<Restaurant>)

    suspend fun get(): List<Restaurant>
}