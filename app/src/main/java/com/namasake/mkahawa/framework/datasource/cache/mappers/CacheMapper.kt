package com.namasake.mkahawa.framework.datasource.cache.mappers

import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.util.EntityMapper
import com.namasake.mkahawa.framework.datasource.cache.model.RestaurantCacheEntity
import javax.inject.Inject

class CacheMapper @Inject constructor() :EntityMapper<RestaurantCacheEntity,Restaurant> {
    override fun mapFromEntity(entity: RestaurantCacheEntity): Restaurant {
        return Restaurant(
            name = entity.name,
            type = entity.type,
            logo = entity.logo,
            address = entity.address
        )
    }

    override fun mapToEntity(domainModel: Restaurant): RestaurantCacheEntity {
        return RestaurantCacheEntity(
            name = domainModel.name,
            type = domainModel.type,
            logo = domainModel.logo,
            address = domainModel.address
        )
    }
    fun mapFromEntityList(entities: List<RestaurantCacheEntity>): List<Restaurant>{
        return entities.map { mapFromEntity(it) }
    }
}