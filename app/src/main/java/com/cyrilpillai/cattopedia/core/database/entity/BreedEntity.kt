package com.cyrilpillai.cattopedia.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cyrilpillai.cattopedia.core.network.model.BreedResource
import com.cyrilpillai.cattopedia.core.network.model.getAspectRatio

@Entity(tableName = "breeds")
data class BreedEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "origin") val origin: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "temperament") val temperament: String,
    @ColumnInfo(name = "alt_names") val altNames: String,
    @ColumnInfo(name = "life_span") val lifeSpan: String,
    @ColumnInfo(name = "indoor") val indoor: Boolean,
    @ColumnInfo(name = "lap") val lap: Boolean,
    @ColumnInfo(name = "adaptability") val adaptability: Int,
    @ColumnInfo(name = "affection_level") val affectionLevel: Int,
    @ColumnInfo(name = "child_friendly") val childFriendly: Int,
    @ColumnInfo(name = "dog_friendly") val dogFriendly: Int,
    @ColumnInfo(name = "stranger_friendly") val strangerFriendly: Int,
    @ColumnInfo(name = "energy_level") val energyLevel: Int,
    @ColumnInfo(name = "grooming") val grooming: Int,
    @ColumnInfo(name = "health_issues") val healthIssues: Int,
    @ColumnInfo(name = "intelligence") val intelligence: Int,
    @ColumnInfo(name = "shedding_level") val sheddingLevel: Int,
    @ColumnInfo(name = "social_needs") val socialNeeds: Int,
    @ColumnInfo(name = "vocalisation") val vocalisation: Int,
    @ColumnInfo(name = "experimental") val experimental: Boolean,
    @ColumnInfo(name = "hairless") val hairless: Boolean,
    @ColumnInfo(name = "natural") val natural: Boolean,
    @ColumnInfo(name = "rare") val rare: Boolean,
    @ColumnInfo(name = "rex") val rex: Boolean,
    @ColumnInfo(name = "short_legs") val shortLegs: Boolean,
    @ColumnInfo(name = "hypoallergenic") val hypoallergenic: Boolean,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "image_aspect_ratio") val imageAspectRatio: Float
) {
    constructor(breedResource: BreedResource) : this(
        id = breedResource.id,
        name = breedResource.name,
        origin = breedResource.origin,
        description = breedResource.description,
        temperament = breedResource.temperament,
        altNames = breedResource.altNames,
        lifeSpan = breedResource.lifeSpan,
        indoor = breedResource.indoor,
        lap = breedResource.lap,
        adaptability = breedResource.adaptability,
        affectionLevel = breedResource.affectionLevel,
        childFriendly = breedResource.childFriendly,
        dogFriendly = breedResource.dogFriendly,
        strangerFriendly = breedResource.strangerFriendly,
        energyLevel = breedResource.energyLevel,
        grooming = breedResource.grooming,
        healthIssues = breedResource.healthIssues,
        intelligence = breedResource.intelligence,
        sheddingLevel = breedResource.sheddingLevel,
        socialNeeds = breedResource.socialNeeds,
        vocalisation = breedResource.vocalisation,
        experimental = breedResource.experimental,
        hairless = breedResource.hairless,
        natural = breedResource.natural,
        rare = breedResource.rare,
        rex = breedResource.rex,
        shortLegs = breedResource.shortLegs,
        hypoallergenic = breedResource.hypoallergenic,
        imageUrl = breedResource.image?.url.orEmpty(),
        imageAspectRatio = breedResource.image.getAspectRatio()
    )
}