package com.cyrilpillai.cattopedia.detail.domain

import com.cyrilpillai.cattopedia.core.database.dao.BreedDao
import com.cyrilpillai.cattopedia.core.database.entity.BreedImageEntity
import com.cyrilpillai.cattopedia.core.database.relation.BreedWithImages
import com.cyrilpillai.cattopedia.core.network.ApiService
import com.cyrilpillai.cattopedia.core.network.result.onException
import com.cyrilpillai.cattopedia.core.network.result.onSuccess
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreedDetailRepo @Inject constructor(
    private val breedDao: BreedDao,
    private val apiService: ApiService,
) {

    suspend fun getBreedImagesCount(breedId: String?): Int {
        return breedDao.getBreedImagesCount(requireBreedId(breedId))
    }

    suspend fun fetchBreedImages(breedId: String?) {
        val id = requireBreedId(breedId)
        apiService.getBreedImages(
            breedsId = id,
            limit = BREED_IMAGES_LIMIT
        ).onSuccess { breedImages ->
            breedDao.insertBreedImages(
                *breedImages
                    .map { BreedImageEntity(id, it) }
                    .toTypedArray()
            )
        }.onException { it.printStackTrace() }
    }

    fun getBreed(breedId: String?): Flow<BreedWithImages> {
        return breedDao.getBreedWithImages(requireBreedId(breedId))
    }

    private fun requireBreedId(breedId: String?): String {
        if (breedId != null) {
            return breedId
        } else {
            throw IllegalArgumentException("Breed ID cannot be null")
        }
    }
}

const val BREED_IMAGES_LIMIT = 25