package com.cyrilpillai.cattopedia.detail.view.components

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailItem
import com.cyrilpillai.cattopedia.detail.view.model.LevelItem
import com.cyrilpillai.cattopedia.detail.view.model.TemperamentItem

@Composable
fun Body(
    breedDetailItem: BreedDetailItem,
    headerHeight: Dp,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(headerHeight))

        Description(breedDetailItem.description)

        Origin(breedDetailItem.origin)

        LifeSpan(breedDetailItem.lifeSpan)

        Temperament(breedDetailItem.temperament)

        breedDetailItem.levels.forEach {
            LevelIndicator(it)
        }
    }
}

@Composable
fun Description(
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun Origin(
    origin: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Origin",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = origin,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun LifeSpan(
    lifeSpan: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Life Span",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = lifeSpan,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Temperament(
    temperament: List<TemperamentItem>,
    modifier: Modifier = Modifier
) {
    Log.d("Cattopedia", "Temperament $temperament")
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Temperament",
            style = MaterialTheme.typography.titleMedium
        )
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 8.dp)
        ) {
            temperament.forEach {
                Text(
                    text = it.text,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .background(
                            color = Color(it.color),
                            shape = RoundedCornerShape(48.dp),
                        )
                        .padding(
                            vertical = 4.dp,
                            horizontal = 16.dp
                        )
                )
            }
        }
    }
}

@Composable
fun LevelIndicator(
    levelItem: LevelItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val color = Color(levelItem.color)
        Text(
            text = levelItem.title,
            style = MaterialTheme.typography.titleMedium
        )
        LinearProgressIndicator(
            progress = { levelItem.level },
            strokeCap = StrokeCap.Round,
            color = color,
            trackColor = color.copy(alpha = 0.2f),
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .padding(top = 8.dp)
        )
    }
}