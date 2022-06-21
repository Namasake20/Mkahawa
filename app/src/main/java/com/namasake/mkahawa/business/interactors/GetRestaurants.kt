package com.namasake.mkahawa.business.interactors

import com.namasake.mkahawa.business.data.cache.CacheDataSource
import com.namasake.mkahawa.business.data.network.NetworkDataSource
import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.state.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay

class GetRestaurants
constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {
    private val TAG: String = "AppDebug"

    suspend fun execute():Flow<DataState<List<Restaurant>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val networkRestaurants = networkDataSource.get()
        val cachedRestaurants = cacheDataSource.get()
        emit(DataState.Success(cachedRestaurants))

    }
}