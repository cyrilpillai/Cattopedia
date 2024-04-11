package com.cyrilpillai.cattopedia.detail.view.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cyrilpillai.cattopedia.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    scrollState: ScrollState,
    headerHeight: Dp,
    toolbarHeight: Dp,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val headerHeightInPx = LocalDensity.current.run { headerHeight.toPx() }
    val toolbarHeightInPx = LocalDensity.current.run { toolbarHeight.toPx() }

    val toolbarBottom by remember {
        mutableFloatStateOf(headerHeightInPx - toolbarHeightInPx)
    }

    val showToolbar by remember {
        derivedStateOf {
            scrollState.value >= toolbarBottom
        }
    }

    TopAppBar(
        title = {},
        colors = TopAppBarColors(
            containerColor = if (showToolbar) Purple40 else Color.Transparent,
            titleContentColor = Purple40,
            actionIconContentColor = Purple40,
            navigationIconContentColor = Color.White,
            scrolledContainerColor = Purple40
        ),
        navigationIcon = {
            IconButton(
                onClick = onBackClicked,
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = if (showToolbar) {
                            Color.Transparent
                        } else {
                            Color.Black.copy(alpha = 0.2f)
                        },
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        modifier = modifier
    )
}