package com.namasake.mkahawa.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
class RestaurantCacheEntity (
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "logo")
    var logo: String,

    @ColumnInfo(name = "address")
    var address: String,

)