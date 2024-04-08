package com.cyrilpillai.cattopedia.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cyrilpillai.cattopedia.detail.view.BreedDetailRoute

const val BREED_ID_ARG = "breed_id"
const val BREED_DETAIL_ROUTE_BASE = "breed_detail_route"
const val BREED_DETAIL_ROUTE = "breed_detail_route/{$BREED_ID_ARG}"

fun NavController.navigateToBreedDetailScreen(
    breedId: String?,
    navOptions: NavOptions? = null
) {
    navigate("$BREED_DETAIL_ROUTE_BASE/$breedId", navOptions)
}

fun NavGraphBuilder.breedDetailScreen() {
    composable(
        route = BREED_DETAIL_ROUTE,
        arguments = listOf(navArgument(BREED_ID_ARG) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        BreedDetailRoute()
    }
}