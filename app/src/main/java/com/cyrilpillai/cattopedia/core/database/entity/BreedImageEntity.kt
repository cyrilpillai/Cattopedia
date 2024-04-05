package com.cyrilpillai.cattopedia.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cyrilpillai.cattopedia.core.network.model.BreedImageResource

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
    @ColumnInfo(name = "url") val url: String
) {
    constructor(
        breedId: String,
        breedImageResource: BreedImageResource
    ) : this(
        id = breedImageResource.id,
        breedId = breedId,
        url = breedImageResource.url
    )
}