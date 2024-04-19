package com.cyrilpillai.cattopedia.core.network

import com.cyrilpillai.cattopedia.core.network.model.BreedImageResource
import com.cyrilpillai.cattopedia.core.network.model.BreedResource
import com.cyrilpillai.cattopedia.core.network.result.model.NetworkResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/breeds")
    suspend fun getAllBreeds(): NetworkResult<List<BreedResource>>

    @GET("v1/images/search")
    suspend fun getBreedImages(
        @Query("breed_ids") breedsId: String,
        @Query("limit") limit: Int
    ): NetworkResult<List<BreedImageResource>>
}