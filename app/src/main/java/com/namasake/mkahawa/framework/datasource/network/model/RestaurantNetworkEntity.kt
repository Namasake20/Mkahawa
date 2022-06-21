package com.namasake.mkahawa.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RestaurantNetworkEntity(
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("logo")
    @Expose
    var logo: String,

    @SerializedName("address")
    @Expose
    var address: String
)