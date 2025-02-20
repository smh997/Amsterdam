package com.example.amsterdam.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amsterdam.R
import com.example.amsterdam.data.local.LocalPlacesDataProvider
import com.example.compose.AmsterdamTheme

@Composable
fun PlaceContents(
    amsterdamUiState: AmsterdamUiState,
    onPlaceScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onPlaceScreenBackPressed()
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Header(
            title = stringResource(R.string.app_name),
            isFullScreen = true,
            onBackButtonClicked = onPlaceScreenBackPressed
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                .background(color = MaterialTheme.colorScheme.)
            ) {
                Image(
                    painter = painterResource(id = amsterdamUiState.currentSelectedPlace.imageRes),
                    contentDescription = stringResource(amsterdamUiState.currentSelectedPlace.name),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer),
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
                    stringResource(amsterdamUiState.currentSelectedPlace.name),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = null,
                    Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    stringResource(amsterdamUiState.currentSelectedPlace.address),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.map_24),
                    contentDescription = null,
                    Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    stringResource(R.string.googleMaps),
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }

            Text(
                stringResource(amsterdamUiState.currentSelectedPlace.description),
                style = MaterialTheme.typography.bodySmall
            )
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PlaceContentsPreview() {
    val places = LocalPlacesDataProvider.allPlaces.groupBy { it.placeType }
    AmsterdamTheme(
//        darkTheme = true
        dynamicColor = false
    ) {
        PlaceContents(
            AmsterdamUiState(
                places = places,
            ),
            {},
        )
    }
}