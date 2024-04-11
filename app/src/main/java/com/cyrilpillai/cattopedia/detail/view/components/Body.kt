package com.cyrilpillai.cattopedia.detail.view.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Body(
    description: String,
    headerHeight: Dp,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(headerHeight))

        repeat(20) {
            Text(
                text = description,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}