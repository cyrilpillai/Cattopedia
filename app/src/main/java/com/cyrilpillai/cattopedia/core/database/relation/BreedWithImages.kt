package com.cyrilpillai.cattopedia.core.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity
import com.cyrilpillai.cattopedia.core.database.entity.BreedImageEntity

data class BreedWithImages(
    @Embedded val breed: BreedEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "breed_id"
    )
    val images: List<BreedImageEntity>
)