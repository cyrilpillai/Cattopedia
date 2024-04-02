package com.cyrilpillai.cattopedia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cyrilpillai.cattopedia.detail.navigation.breedDetailScreen
import com.cyrilpillai.cattopedia.detail.navigation.navigateToBreedDetailScreen
import com.cyrilpillai.cattopedia.list.navigation.BREED_LIST_ROUTE
import com.cyrilpillai.cattopedia.list.navigation.breedListScreen

@Composable
fun CattopediaNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = BREED_LIST_ROUTE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        breedListScreen(navController::navigateToBreedDetailScreen)
        breedDetailScreen(navController::popBackStack)
    }
}