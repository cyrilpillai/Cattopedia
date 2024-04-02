package com.cyrilpillai.cattopedia.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cyrilpillai.cattopedia.detail.view.BreedDetailRoute

const val BREED_DETAIL_ROUTE = "breed_detail_route"

fun NavController.navigateToBreedDetailScreen(
    navOptions: NavOptions? = null
) {
    navigate(BREED_DETAIL_ROUTE, navOptions)
}

fun NavGraphBuilder.breedDetailScreen(
    onPreviousClicked: () -> Unit
) {
    composable(
        route = BREED_DETAIL_ROUTE,
    ) {
        BreedDetailRoute(onPreviousClicked)
    }
}