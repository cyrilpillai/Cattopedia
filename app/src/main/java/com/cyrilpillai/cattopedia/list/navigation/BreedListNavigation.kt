package com.cyrilpillai.cattopedia.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.cyrilpillai.cattopedia.list.view.BreedListRoute

const val BREED_LIST_ROUTE = "breed_list_route"

fun NavController.navigateToBreedListScreen(
    navOptions: NavOptions
) {
    navigate(BREED_LIST_ROUTE, navOptions)
}

fun NavGraphBuilder.breedListScreen(
    onBreedClicked: (breedId: String) -> Unit
) {
    composable(
        route = BREED_LIST_ROUTE,
    ) {
        BreedListRoute(onBreedClicked)
    }
}