package com.cyrilpillai.cattopedia.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedImageResource(
    @Json(name = "id") val id: String = "",
    @Json(name = "url") val url: String = "",
    @Json(name = "width") val width: Int = 0,
    @Json(name = "height") val height: Int = 0,
)

fun BreedImageResource?.getAspectRatio(): Float {
    return this?.width?.toFloat()?.div(height.toFloat()) ?: 1f
}