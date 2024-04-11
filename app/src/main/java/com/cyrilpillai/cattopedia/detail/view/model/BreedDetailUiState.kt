package com.cyrilpillai.cattopedia.detail.view.model

import com.cyrilpillai.cattopedia.core.database.relation.BreedWithImages

sealed class BreedDetailUiState {
    data object Loading : BreedDetailUiState()

    data class Success(
        val breedDetailItem: BreedDetailItem
    ) : BreedDetailUiState()

    data class Failure(
        val errorMessage: String
    ) : BreedDetailUiState()
}

data class BreedDetailItem(
    val id: String,
    val name: String,
    val origin: String,
    val description: String,
    val temperament: String,
    val altNames: String,
    val lifeSpan: String,
    val indoor: Boolean,
    val lap: Boolean,
    val adaptability: Int,
    val affectionLevel: Int,
    val childFriendly: Int,
    val dogFriendly: Int,
    val strangerFriendly: Int,
    val energyLevel: Int,
    val grooming: Int,
    val healthIssues: Int,
    val intelligence: Int,
    val sheddingLevel: Int,
    val socialNeeds: Int,
    val vocalisation: Int,
    val experimental: Boolean,
    val hairless: Boolean,
    val natural: Boolean,
    val rare: Boolean,
    val rex: Boolean,
    val shortLegs: Boolean,
    val hypoallergenic: Boolean,
    val imageUrls: List<String>
) {
    constructor(breedWithImages: BreedWithImages) : this(
        id = breedWithImages.breed.id,
        name = breedWithImages.breed.name,
        origin = breedWithImages.breed.origin,
        description = breedWithImages.breed.description,
        temperament = breedWithImages.breed.temperament,
        altNames = breedWithImages.breed.altNames,
        lifeSpan = breedWithImages.breed.lifeSpan,
        indoor = breedWithImages.breed.indoor,
        lap = breedWithImages.breed.lap,
        adaptability = breedWithImages.breed.adaptability,
        affectionLevel = breedWithImages.breed.affectionLevel,
        childFriendly = breedWithImages.breed.childFriendly,
        dogFriendly = breedWithImages.breed.dogFriendly,
        strangerFriendly = breedWithImages.breed.strangerFriendly,
        energyLevel = breedWithImages.breed.energyLevel,
        grooming = breedWithImages.breed.grooming,
        healthIssues = breedWithImages.breed.healthIssues,
        intelligence = breedWithImages.breed.intelligence,
        sheddingLevel = breedWithImages.breed.sheddingLevel,
        socialNeeds = breedWithImages.breed.socialNeeds,
        vocalisation = breedWithImages.breed.vocalisation,
        experimental = breedWithImages.breed.experimental,
        hairless = breedWithImages.breed.hairless,
        natural = breedWithImages.breed.natural,
        rare = breedWithImages.breed.rare,
        rex = breedWithImages.breed.rex,
        shortLegs = breedWithImages.breed.shortLegs,
        hypoallergenic = breedWithImages.breed.hypoallergenic,
        imageUrls = breedWithImages.images.map { it.url }
    )
}