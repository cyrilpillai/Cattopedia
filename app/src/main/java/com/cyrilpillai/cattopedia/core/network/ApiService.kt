package com.cyrilpillai.cattopedia.core.network

import com.cyrilpillai.cattopedia.core.network.model.BreedResource
import com.cyrilpillai.cattopedia.core.network.result.model.NetworkResult
import retrofit2.http.GET

interface ApiService {
    @GET("v1/breeds")
    suspend fun getAllBreeds(): NetworkResult<List<BreedResource>>
}