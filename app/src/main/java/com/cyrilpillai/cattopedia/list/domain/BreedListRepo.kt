package com.cyrilpillai.cattopedia.list.domain

import com.cyrilpillai.cattopedia.core.database.dao.BreedDao
import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity
import com.cyrilpillai.cattopedia.core.database.entity.BreedImageEntity
import com.cyrilpillai.cattopedia.core.network.ApiService
import com.cyrilpillai.cattopedia.core.network.result.onException
import com.cyrilpillai.cattopedia.core.network.result.onSuccess
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreedListRepo @Inject constructor(
    private val breedDao: BreedDao,
    private val apiService: ApiService,
) {
    suspend fun getBreedCount(): Int {
        return breedDao.getBreedCount()
    }

    suspend fun fetchAllBreeds() {
        apiService.getAllBreeds()
            .onSuccess { breedResources ->
                breedResources.forEach {
                    //Save Breed only if image is available
                    if (it.image != null) {
                        breedDao.insertBreedWithImages(
                            BreedEntity(it),
                            listOf(BreedImageEntity(it.id, it.image))
                        )
                    }
                }
            }
            .onException { it.printStackTrace() }
    }

    fun getAllBreeds(): Flow<List<BreedEntity>> {
        return breedDao.getAllBreeds()
    }
}