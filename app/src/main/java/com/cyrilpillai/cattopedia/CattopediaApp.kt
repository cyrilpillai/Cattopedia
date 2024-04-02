package com.cyrilpillai.cattopedia

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cyrilpillai.cattopedia.navigation.CattopediaNavHost
import com.cyrilpillai.cattopedia.ui.theme.CattopediaTheme

@Composable
fun CattopediaApp() {
    CattopediaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CattopediaNavHost(navController = rememberNavController())
        }
    }
}

@Preview
@Composable
fun CattopediaAppPreview() {
    CattopediaApp()
}