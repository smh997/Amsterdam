package com.example.amsterdam.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amsterdam.R
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
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
        PlaceContentsDetails(place = amsterdamUiState.currentSelectedPlace)
    }
}

@Composable
fun PlaceContentsDetails(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        PlacePicture(
            placeImageRes = place.imageRes,
            contentDescription = stringResource(place.name)
        )

        PlaceNameFrame(
            placeNameRes = place.name,
            placeType = place.placeType
        )

        PlaceAddress(placeAddressRes = place.address)

        PlaceGoogleMap(placeGoogleMapRes = place.googleMapsUrl)

        // Place Description
        Text(
            stringResource(place.description),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun PlacePicture(placeImageRes: Int, contentDescription: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = placeImageRes),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun PlaceNameFrame(placeNameRes: Int, placeType: PlaceType, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(placeType.iconRes),
            contentDescription = null,
            Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(Modifier.width(8.dp))
        Text(
            stringResource(placeNameRes),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun PlaceAddress(placeAddressRes: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
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
            stringResource(placeAddressRes),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun PlaceGoogleMap(placeGoogleMapRes: Int, modifier: Modifier= Modifier) {
    val context = LocalContext.current
    val url: String = stringResource(placeGoogleMapRes)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )
                context.startActivity(intent)
            },
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
            color = MaterialTheme.colorScheme.tertiary,
            textDecoration = TextDecoration.Underline,
        )
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