package com.cyrilpillai.cattopedia.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cyrilpillai.cattopedia.core.network.model.BreedResource

@Entity(tableName = "breeds")
data class BreedEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "origin") val origin: String,
    @ColumnInfo(name = "image_url") val imageUrl: String
) {
    constructor(breedResource: BreedResource) : this(
        id = breedResource.id,
        name = breedResource.name,
        origin = breedResource.origin,
        imageUrl = breedResource.image?.url ?: ""
    )
}