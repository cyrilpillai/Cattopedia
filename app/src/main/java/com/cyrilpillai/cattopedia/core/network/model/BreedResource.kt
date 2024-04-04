package com.cyrilpillai.cattopedia.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedResource(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "origin") val origin: String,
    @Json(name = "image") val image: BreedImageResource? = null
)