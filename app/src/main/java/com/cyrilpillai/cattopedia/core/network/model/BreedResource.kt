package com.cyrilpillai.cattopedia.core.network.model

import com.cyrilpillai.cattopedia.core.network.adapter.BooleanType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedResource(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "origin") val origin: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "temperament") val temperament: String = "",
    @Json(name = "alt_names") val altNames: String = "",
    @Json(name = "life_span") val lifeSpan: String = "",
    @Json(name = "indoor") @BooleanType val indoor: Boolean = false,
    @Json(name = "lap") @BooleanType val lap: Boolean = false,
    @Json(name = "adaptability") val adaptability: Int = 0,
    @Json(name = "affection_level") val affectionLevel: Int = 0,
    @Json(name = "child_friendly") val childFriendly: Int = 0,
    @Json(name = "dog_friendly") val dogFriendly: Int = 0,
    @Json(name = "stranger_friendly") val strangerFriendly: Int = 0,
    @Json(name = "energy_level") val energyLevel: Int = 0,
    @Json(name = "grooming") val grooming: Int = 0,
    @Json(name = "health_issues") val healthIssues: Int = 0,
    @Json(name = "intelligence") val intelligence: Int = 0,
    @Json(name = "shedding_level") val sheddingLevel: Int = 0,
    @Json(name = "social_needs") val socialNeeds: Int = 0,
    @Json(name = "vocalisation") val vocalisation: Int = 0,
    @Json(name = "experimental") @BooleanType val experimental: Boolean = false,
    @Json(name = "hairless") @BooleanType val hairless: Boolean = false,
    @Json(name = "natural") @BooleanType val natural: Boolean = false,
    @Json(name = "rare") @BooleanType val rare: Boolean = false,
    @Json(name = "rex") @BooleanType val rex: Boolean = false,
    @Json(name = "short_legs") @BooleanType val shortLegs: Boolean = false,
    @Json(name = "hypoallergenic") @BooleanType val hypoallergenic: Boolean = false,
    @Json(name = "image") val image: BreedImageResource? = null
)