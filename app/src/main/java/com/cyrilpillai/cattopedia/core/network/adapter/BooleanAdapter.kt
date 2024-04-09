package com.cyrilpillai.cattopedia.core.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Backend API sends 0s & 1s for certain fields to denote whether that attribute is applicable or not.
 * This is a perfect candidate for a Boolean data type instead of Int and thus we convert it
 * to ensure the app logic is based on Boolean throughout the codebase and only transformed
 * for network interaction (since the API contract isn't in our control)
 */
class BooleanAdapter {
    @FromJson
    @BooleanType
    fun fromJson(value: Int?): Boolean {
        return value == 1
    }

    @ToJson
    fun toJson(@BooleanType value: Boolean): Int {
        return if (value) 1 else 0
    }
}