package com.cyrilpillai.cattopedia.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity
import com.cyrilpillai.cattopedia.core.database.entity.BreedImageEntity
import com.cyrilpillai.cattopedia.core.database.relation.BreedWithImages
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreed(breed: BreedEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreedImages(vararg breedImages: BreedImageEntity)

    @Transaction
    suspend fun insertBreedWithImages(breed: BreedEntity, images: List<BreedImageEntity>) {
        insertBreed(breed)
        insertBreedImages(*images.toTypedArray())
    }

    @Query("SELECT COUNT(id) FROM breeds")
    suspend fun getBreedCount(): Int

    @Transaction
    @Query("SELECT * FROM breeds")
    fun getAllBreeds(): Flow<List<BreedEntity>>

    @Transaction
    @Query("SELECT * FROM breeds WHERE id = :breedId")
    fun getBreedWithImages(breedId: String): Flow<BreedWithImages>

    @Query("SELECT COUNT(id) FROM breed_images WHERE id = :breedId")
    suspend fun getBreedImagesCount(breedId: String): Int
}