package com.cyrilpillai.cattopedia.detail.domain

import com.cyrilpillai.cattopedia.core.database.dao.BreedDao
import com.cyrilpillai.cattopedia.core.database.relation.BreedWithImages
import com.cyrilpillai.cattopedia.core.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreedDetailRepo @Inject constructor(
    private val breedDao: BreedDao,
    private val apiService: ApiService,
) {
    fun getBreed(breedId: String?): Flow<BreedWithImages> {
        return if (breedId != null) {
            breedDao.getBreedWithImages(breedId)
        } else {
            throw IllegalArgumentException("Breed ID cannot be null")
        }
    }
}