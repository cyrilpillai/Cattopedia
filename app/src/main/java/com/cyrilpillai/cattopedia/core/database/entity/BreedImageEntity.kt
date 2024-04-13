package com.cyrilpillai.cattopedia.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cyrilpillai.cattopedia.core.network.model.BreedImageResource
import com.cyrilpillai.cattopedia.core.network.model.getAspectRatio

@Entity(
    tableName = "breed_images",
    foreignKeys = [ForeignKey(
        entity = BreedEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("breed_id"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class BreedImageEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "breed_id") val breedId: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "image_aspect_ratio") val imageAspectRatio: Float
) {
    constructor(
        breedId: String,
        breedImageResource: BreedImageResource
    ) : this(
        id = breedImageResource.id,
        breedId = breedId,
        url = breedImageResource.url,
        imageAspectRatio = breedImageResource.getAspectRatio()
    )
}