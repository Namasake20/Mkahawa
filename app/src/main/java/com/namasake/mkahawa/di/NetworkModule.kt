package com.namasake.mkahawa.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.namasake.mkahawa.business.data.network.NetworkDataSource
import com.namasake.mkahawa.business.data.network.NetworkDataSourceImpl
import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.util.EntityMapper
import com.namasake.mkahawa.framework.datasource.network.mappers.NetworkMapper
import com.namasake.mkahawa.framework.datasource.network.model.RestaurantNetworkEntity
import com.namasake.mkahawa.framework.datasource.network.retrofit.RestaurantRetroServiceServiceImpl
import com.namasake.mkahawa.framework.datasource.network.retrofit.RestaurantRetrofit
import com.namasake.mkahawa.framework.datasource.network.retrofit.RestaurantRetrofit.Companion.BASE_URL
import com.namasake.mkahawa.framework.datasource.network.retrofit.RestaurantRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<RestaurantNetworkEntity,Restaurant>{
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder():Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideRestaurantService(retrofit: Retrofit.Builder): RestaurantRetrofit {
        return retrofit.build().create(RestaurantRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(restaurantRetrofit: RestaurantRetrofit):RestaurantRetrofitService{
        return RestaurantRetroServiceServiceImpl(restaurantRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        restaurantRetrofitService: RestaurantRetrofitService,
        networkMapper: NetworkMapper
    ):NetworkDataSource{
        return NetworkDataSourceImpl(restaurantRetrofitService,networkMapper)
    }

}