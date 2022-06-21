package com.namasake.mkahawa.business.data.network

import com.namasake.mkahawa.business.domain.model.Restaurant

interface NetworkDataSource {
    suspend fun get():List<Restaurant>
}