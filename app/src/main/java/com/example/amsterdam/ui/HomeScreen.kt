package com.example.amsterdam.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amsterdam.data.Place
import com.example.amsterdam.data.PlaceType
import com.example.amsterdam.data.ScreenType
import com.example.amsterdam.ui.utils.Header
import com.example.amsterdam.ui.utils.NavigationType
import com.example.compose.AmsterdamTheme

@Composable
fun HomeScreen(
    amsterdamUiState: AmsterdamUiState,
    navigationType: NavigationType,
    onTabPressed: (PlaceType) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    onPlaceTypeScreenBackPressed: () -> Unit,
    onPlaceScreenBackPressed: () -> Unit,
    onNextPlaceClicked: (Place) -> Unit,
    onPreviousPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    if (navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(240.dp)) {
                    NavigationDrawerContent(
                        selectedDestination = amsterdamUiState.currentPlaceType,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = PlaceType.entries,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(12.dp)
                    )
                }
            },
            modifier = modifier
        ) {
            Column (

            ){
                Header()
                Row (
                    modifier = Modifier.weight(1f),
                ) {
                    PlaceTypeContents(
                        amsterdamUiState = amsterdamUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        navigationType = navigationType,
                        modifier = Modifier.weight(1f)
                    )
                    PlaceContents(
                        amsterdamUiState = amsterdamUiState,
                        onNextPlaceClicked = onNextPlaceClicked,
                        onPreviousPlaceClicked = onPreviousPlaceClicked,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

        }
    } else {
        AmsterdamAppContent(
            amsterdamUiState = amsterdamUiState,
            navigationType = navigationType,
            onTabPressed = onTabPressed,
            onPlaceCardPressed = onPlaceCardPressed,
            onPlaceTypeScreenBackPressed = onPlaceTypeScreenBackPressed,
            onPlaceScreenBackPressed = onPlaceScreenBackPressed,
            onNextPlaceClicked = onNextPlaceClicked,
            onPreviousPlaceClicked = onPreviousPlaceClicked,
            navigationItemContentList = PlaceType.entries,
            modifier = modifier,
        )
    }
}

@Composable
private fun NavigationDrawerContent(
    selectedDestination: PlaceType,
    onTabPressed: ((PlaceType) -> Unit),
    navigationItemContentList: List<PlaceType>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem,
                label = {
                    Text(
                        text = navItem.label,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(navItem.iconRes),
                        contentDescription = navItem.label
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem) }
            )
        }
    }
}

@Composable
private fun AmsterdamAppContent(
    amsterdamUiState: AmsterdamUiState,
    navigationType: NavigationType,
    onTabPressed: ((PlaceType) -> Unit),
    onPlaceCardPressed: (Place) -> Unit,
    onPlaceTypeScreenBackPressed: () -> Unit,
    navigationItemContentList: List<PlaceType>,
    onPlaceScreenBackPressed: () -> Unit,
    onNextPlaceClicked: (Place) -> Unit,
    onPreviousPlaceClicked: (Place) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        AnimatedVisibility(
            visible = navigationType == NavigationType.NAVIGATION_RAIL && amsterdamUiState.currentScreen == ScreenType.PlaceType
        ) {
            AmsterdamNavigationRail(
                currentTab = amsterdamUiState.currentPlaceType,
                onTabPressed = onTabPressed,
                navigationItemContentList = PlaceType.entries,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header(
                isFullScreen = amsterdamUiState.currentScreen == ScreenType.Place || (amsterdamUiState.currentScreen == ScreenType.PlaceType && navigationType == NavigationType.BOTTOM_NAVIGATION),
                onBackButtonClicked = if (amsterdamUiState.currentScreen == ScreenType.Place) onPlaceScreenBackPressed else onPlaceTypeScreenBackPressed
            )
            when (amsterdamUiState.currentScreen) {
                ScreenType.Home -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(PlaceType.entries) { category ->
                            CategoryCard(category, onClick = onTabPressed)
                        }
                    }
                }

                ScreenType.PlaceType -> {
                    PlaceTypeContents(
                        amsterdamUiState = amsterdamUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        onPlaceTypeScreenBackPressed = onPlaceTypeScreenBackPressed,
                        navigationType = navigationType,
                        backEnabled = navigationType == NavigationType.BOTTOM_NAVIGATION,
                        modifier = Modifier
                            .weight(1f)
                    )
                    AnimatedVisibility(visible = navigationType == NavigationType.BOTTOM_NAVIGATION) {
                        AmsterdamBottomNavigationBar(
                            currentTab = amsterdamUiState.currentPlaceType,
                            onTabPressed = onTabPressed,
                            navigationItemContentList = navigationItemContentList,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }

                else -> {
                    PlaceContents(
                        amsterdamUiState = amsterdamUiState,
                        onNextPlaceClicked = onNextPlaceClicked,
                        onPreviousPlaceClicked = onPreviousPlaceClicked,
                        onPlaceScreenBackPressed = onPlaceScreenBackPressed,
                        backEnabled = true,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
private fun AmsterdamBottomNavigationBar(
    currentTab: PlaceType,
    onTabPressed: ((PlaceType) -> Unit),
    navigationItemContentList: List<PlaceType>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem,
                onClick = { onTabPressed(navItem) },
                icon = {
                    Icon(
                        painter = painterResource(navItem.iconRes),
                        contentDescription = navItem.label
                    )
                }
            )
        }
    }
}

@Composable
fun AmsterdamNavigationRail(
    currentTab: PlaceType,
    onTabPressed: (PlaceType) -> Unit,
    navigationItemContentList: List<PlaceType>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem,
                onClick = { onTabPressed(navItem) },
                icon = {
                    Icon(
                        painter = painterResource(navItem.iconRes),
                        contentDescription = navItem.label
                    )
                }
            )
        }
    }

}

@Composable
fun CategoryCard(
    category: PlaceType,
    onClick: (category: PlaceType) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick(category) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.label,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Text(
                text = category.name,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AmsterdamTheme(dynamicColor = false) {
        HomeScreen(
            amsterdamUiState = AmsterdamUiState(),
            onTabPressed = {},
            onPlaceCardPressed = {},
            onPlaceTypeScreenBackPressed = {},
            onPlaceScreenBackPressed = {},
            onNextPlaceClicked = {},
            onPreviousPlaceClicked = {},
            navigationType = NavigationType.BOTTOM_NAVIGATION,
        )
    }
}