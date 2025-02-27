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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
    onNextPlaceClicked: (Place) -> Unit,
    onPreviousPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier,
    onPlaceScreenBackPressed: () -> Unit = {},
    backEnabled: Boolean = false
) {
    val currentSelectedPlace = amsterdamUiState.currentSelectedPlace
    val currentPlaces = amsterdamUiState.currentPlaces
    if(backEnabled){
        BackHandler {
            onPlaceScreenBackPressed()
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        PlaceContentsDetails(
            place = currentSelectedPlace,
            modifier = Modifier.weight(1f)
        )
        val nextPlaceIndex =
            (currentPlaces.indexOf(currentSelectedPlace) + 1) % currentPlaces.size
        val prevPlaceIndex =
            (currentPlaces.indexOf(currentSelectedPlace) - 1 + currentPlaces.size) % currentPlaces.size
        PlaceNavigationButtons(
            enabled = currentPlaces.size > 1,
            onNextPlaceClicked = { onNextPlaceClicked(currentPlaces[nextPlaceIndex]) },
            onPreviousPlaceClicked = { onPreviousPlaceClicked(currentPlaces[prevPlaceIndex]) },
        )
    }
}

@Composable
fun PlaceNavigationButtons(
    enabled: Boolean,
    onNextPlaceClicked: () -> Unit,
    onPreviousPlaceClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(NavigationBarDefaults.windowInsets)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(
            onClick = onPreviousPlaceClicked,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(16.dp, 8.dp, 8.dp, 16.dp),
            modifier = Modifier.width(90.dp)
        ) {
            Text(stringResource(R.string.previous), fontWeight = FontWeight.Bold)
        }
        TextButton(
            onClick = onNextPlaceClicked,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(8.dp, 16.dp, 16.dp, 8.dp),
            modifier = Modifier.width(90.dp)
        ) {
            Text(stringResource(R.string.next), fontWeight = FontWeight.Bold)
        }
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
            .heightIn(max = 300.dp)
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
            .background(color = MaterialTheme.colorScheme.inversePrimary),
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
fun PlaceGoogleMap(placeGoogleMapRes: Int, modifier: Modifier = Modifier) {
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
            {},
        )
    }
}