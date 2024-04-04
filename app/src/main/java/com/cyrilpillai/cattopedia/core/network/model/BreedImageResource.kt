package com.cyrilpillai.cattopedia.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedImageResource(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String
)