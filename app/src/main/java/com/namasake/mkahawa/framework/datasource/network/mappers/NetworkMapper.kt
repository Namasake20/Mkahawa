package com.namasake.mkahawa.framework.datasource.network.mappers

import com.namasake.mkahawa.business.domain.model.Restaurant
import com.namasake.mkahawa.business.domain.util.EntityMapper
import com.namasake.mkahawa.framework.datasource.network.model.RestaurantNetworkEntity
import javax.inject.Inject

class NetworkMapper @Inject constructor() :EntityMapper<RestaurantNetworkEntity,Restaurant> {
    override fun mapFromEntity(entity: RestaurantNetworkEntity): Restaurant {
        return Restaurant(
            name = entity.name,
            type = entity.type,
            address = entity.address,
            logo = entity.logo
        )
    }

    override fun mapToEntity(domainModel: Restaurant): RestaurantNetworkEntity {
        return RestaurantNetworkEntity(
            name = domainModel.name,
            type = domainModel.type,
            address = domainModel.address,
            logo = domainModel.logo
        )
    }
    fun mapFromEntityList(entities: List<RestaurantNetworkEntity>): List<Restaurant>{
        return entities.map { mapFromEntity(it) }
    }
}