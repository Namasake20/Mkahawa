package com.namasake.mkahawa.di

import android.content.Context
import androidx.room.Room
import com.namasake.mkahawa.business.data.cache.CacheDataSource
import com.namasake.mkahawa.business.data.cache.CacheDataSourceImpl
import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.util.EntityMapper
import com.namasake.mkahawa.framework.datasource.cache.RestaurantDaoService
import com.namasake.mkahawa.framework.datasource.cache.RestaurantDaoServiceImpl
import com.namasake.mkahawa.framework.datasource.cache.database.RestaurantDao
import com.namasake.mkahawa.framework.datasource.cache.database.RestaurantDatabase
import com.namasake.mkahawa.framework.datasource.cache.mappers.CacheMapper
import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<RestaurantCacheEntity,Restaurant>{
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideRestaurantDb(@ApplicationContext context: Context):RestaurantDatabase{
        return Room.databaseBuilder(context,RestaurantDatabase::class.java,RestaurantDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideRestaurantDao(restaurantDatabase: RestaurantDatabase):RestaurantDao{
        return restaurantDatabase.restaurantDao()
    }

    @Singleton
    @Provides
    fun provideDaoService(restaurantDao: RestaurantDao):RestaurantDaoService{
        return RestaurantDaoServiceImpl(restaurantDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(restaurantDaoService: RestaurantDaoService,cacheMapper: CacheMapper)
    :CacheDataSource{
        return CacheDataSourceImpl(restaurantDaoService, cacheMapper)
    }

}