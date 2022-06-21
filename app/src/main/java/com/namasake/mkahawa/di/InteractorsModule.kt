package com.namasake.mkahawa.di

import com.namasake.mkahawa.business.data.cache.CacheDataSource
import com.namasake.mkahawa.business.data.network.NetworkDataSource
import com.namasake.mkahawa.business.interactors.GetRestaurants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Provides
    @Singleton
    fun provideGetRestaurants(cacheDataSource: CacheDataSource,networkDataSource: NetworkDataSource)
    : GetRestaurants{
        return GetRestaurants(cacheDataSource, networkDataSource)
    }
}