package com.example.amsterdam.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.local.LocalPlacesDataProvider
import com.example.amsterdam.ui.utils.NavigationType
import com.example.compose.AmsterdamTheme

@Composable
fun PlaceTypeContents(
    amsterdamUiState: AmsterdamUiState,
    onPlaceCardPressed: (Place) -> Unit,
    navigationType: NavigationType,
    modifier: Modifier = Modifier,
    onPlaceTypeScreenBackPressed: () -> Unit = {},
    backEnabled: Boolean = false,
) {
    if (backEnabled) {
        BackHandler {
            onPlaceTypeScreenBackPressed()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.inversePrimary),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(amsterdamUiState.currentPlaceType.iconRes),
                        contentDescription = null,
                        Modifier.size(40.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        amsterdamUiState.currentPlaceType.label,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

            }
            items(amsterdamUiState.currentPlaces) { place ->
                PlaceCard(
                    place,
                    onClick = onPlaceCardPressed,
                    selected = navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER && amsterdamUiState.currentSelectedPlace == place
                )
            }
        }
    }

}

@Composable
fun PlaceCard(
    place: Place,
    onClick: (place: Place) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(place) },
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceContainerHighest
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = place.imageRes),
                contentDescription = stringResource(place.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(place.name),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PlaceTypeContentsPreview() {
    val places = LocalPlacesDataProvider.allPlaces.groupBy { it.placeType }
    AmsterdamTheme(
//        darkTheme = true
        dynamicColor = false
    ) {
        PlaceTypeContents(
            amsterdamUiState = AmsterdamUiState(
                places = places,
            ),
            navigationType = NavigationType.BOTTOM_NAVIGATION,
            onPlaceCardPressed = {},
            backEnabled = true
        )
    }
}