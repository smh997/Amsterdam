package com.example.compose
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.amsterdam.ui.theme.backgroundDark
import com.example.amsterdam.ui.theme.backgroundDarkHighContrast
import com.example.amsterdam.ui.theme.backgroundDarkMediumContrast
import com.example.amsterdam.ui.theme.backgroundLight
import com.example.amsterdam.ui.theme.backgroundLightHighContrast
import com.example.amsterdam.ui.theme.backgroundLightMediumContrast
import com.example.amsterdam.ui.theme.errorContainerDark
import com.example.amsterdam.ui.theme.errorContainerDarkHighContrast
import com.example.amsterdam.ui.theme.errorContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.errorContainerLight
import com.example.amsterdam.ui.theme.errorContainerLightHighContrast
import com.example.amsterdam.ui.theme.errorContainerLightMediumContrast
import com.example.amsterdam.ui.theme.errorDark
import com.example.amsterdam.ui.theme.errorDarkHighContrast
import com.example.amsterdam.ui.theme.errorDarkMediumContrast
import com.example.amsterdam.ui.theme.errorLight
import com.example.amsterdam.ui.theme.errorLightHighContrast
import com.example.amsterdam.ui.theme.errorLightMediumContrast
import com.example.amsterdam.ui.theme.inverseOnSurfaceDark
import com.example.amsterdam.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.amsterdam.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.amsterdam.ui.theme.inverseOnSurfaceLight
import com.example.amsterdam.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.amsterdam.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.amsterdam.ui.theme.inversePrimaryDark
import com.example.amsterdam.ui.theme.inversePrimaryDarkHighContrast
import com.example.amsterdam.ui.theme.inversePrimaryDarkMediumContrast
import com.example.amsterdam.ui.theme.inversePrimaryLight
import com.example.amsterdam.ui.theme.inversePrimaryLightHighContrast
import com.example.amsterdam.ui.theme.inversePrimaryLightMediumContrast
import com.example.amsterdam.ui.theme.inverseSurfaceDark
import com.example.amsterdam.ui.theme.inverseSurfaceDarkHighContrast
import com.example.amsterdam.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.amsterdam.ui.theme.inverseSurfaceLight
import com.example.amsterdam.ui.theme.inverseSurfaceLightHighContrast
import com.example.amsterdam.ui.theme.inverseSurfaceLightMediumContrast
import com.example.amsterdam.ui.theme.onBackgroundDark
import com.example.amsterdam.ui.theme.onBackgroundDarkHighContrast
import com.example.amsterdam.ui.theme.onBackgroundDarkMediumContrast
import com.example.amsterdam.ui.theme.onBackgroundLight
import com.example.amsterdam.ui.theme.onBackgroundLightHighContrast
import com.example.amsterdam.ui.theme.onBackgroundLightMediumContrast
import com.example.amsterdam.ui.theme.onErrorContainerDark
import com.example.amsterdam.ui.theme.onErrorContainerDarkHighContrast
import com.example.amsterdam.ui.theme.onErrorContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.onErrorContainerLight
import com.example.amsterdam.ui.theme.onErrorContainerLightHighContrast
import com.example.amsterdam.ui.theme.onErrorContainerLightMediumContrast
import com.example.amsterdam.ui.theme.onErrorDark
import com.example.amsterdam.ui.theme.onErrorDarkHighContrast
import com.example.amsterdam.ui.theme.onErrorDarkMediumContrast
import com.example.amsterdam.ui.theme.onErrorLight
import com.example.amsterdam.ui.theme.onErrorLightHighContrast
import com.example.amsterdam.ui.theme.onErrorLightMediumContrast
import com.example.amsterdam.ui.theme.onPrimaryContainerDark
import com.example.amsterdam.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.onPrimaryContainerLight
import com.example.amsterdam.ui.theme.onPrimaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.onPrimaryDark
import com.example.amsterdam.ui.theme.onPrimaryDarkHighContrast
import com.example.amsterdam.ui.theme.onPrimaryDarkMediumContrast
import com.example.amsterdam.ui.theme.onPrimaryLight
import com.example.amsterdam.ui.theme.onPrimaryLightHighContrast
import com.example.amsterdam.ui.theme.onPrimaryLightMediumContrast
import com.example.amsterdam.ui.theme.onSecondaryContainerDark
import com.example.amsterdam.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.onSecondaryContainerLight
import com.example.amsterdam.ui.theme.onSecondaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.onSecondaryDark
import com.example.amsterdam.ui.theme.onSecondaryDarkHighContrast
import com.example.amsterdam.ui.theme.onSecondaryDarkMediumContrast
import com.example.amsterdam.ui.theme.onSecondaryLight
import com.example.amsterdam.ui.theme.onSecondaryLightHighContrast
import com.example.amsterdam.ui.theme.onSecondaryLightMediumContrast
import com.example.amsterdam.ui.theme.onSurfaceDark
import com.example.amsterdam.ui.theme.onSurfaceDarkHighContrast
import com.example.amsterdam.ui.theme.onSurfaceDarkMediumContrast
import com.example.amsterdam.ui.theme.onSurfaceLight
import com.example.amsterdam.ui.theme.onSurfaceLightHighContrast
import com.example.amsterdam.ui.theme.onSurfaceLightMediumContrast
import com.example.amsterdam.ui.theme.onSurfaceVariantDark
import com.example.amsterdam.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.amsterdam.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.amsterdam.ui.theme.onSurfaceVariantLight
import com.example.amsterdam.ui.theme.onSurfaceVariantLightHighContrast
import com.example.amsterdam.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.amsterdam.ui.theme.onTertiaryContainerDark
import com.example.amsterdam.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.onTertiaryContainerLight
import com.example.amsterdam.ui.theme.onTertiaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.onTertiaryDark
import com.example.amsterdam.ui.theme.onTertiaryDarkHighContrast
import com.example.amsterdam.ui.theme.onTertiaryDarkMediumContrast
import com.example.amsterdam.ui.theme.onTertiaryLight
import com.example.amsterdam.ui.theme.onTertiaryLightHighContrast
import com.example.amsterdam.ui.theme.onTertiaryLightMediumContrast
import com.example.amsterdam.ui.theme.outlineDark
import com.example.amsterdam.ui.theme.outlineDarkHighContrast
import com.example.amsterdam.ui.theme.outlineDarkMediumContrast
import com.example.amsterdam.ui.theme.outlineLight
import com.example.amsterdam.ui.theme.outlineLightHighContrast
import com.example.amsterdam.ui.theme.outlineLightMediumContrast
import com.example.amsterdam.ui.theme.outlineVariantDark
import com.example.amsterdam.ui.theme.outlineVariantDarkHighContrast
import com.example.amsterdam.ui.theme.outlineVariantDarkMediumContrast
import com.example.amsterdam.ui.theme.outlineVariantLight
import com.example.amsterdam.ui.theme.outlineVariantLightHighContrast
import com.example.amsterdam.ui.theme.outlineVariantLightMediumContrast
import com.example.amsterdam.ui.theme.primaryContainerDark
import com.example.amsterdam.ui.theme.primaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.primaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.primaryContainerLight
import com.example.amsterdam.ui.theme.primaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.primaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.primaryDark
import com.example.amsterdam.ui.theme.primaryDarkHighContrast
import com.example.amsterdam.ui.theme.primaryDarkMediumContrast
import com.example.amsterdam.ui.theme.primaryLight
import com.example.amsterdam.ui.theme.primaryLightHighContrast
import com.example.amsterdam.ui.theme.primaryLightMediumContrast
import com.example.amsterdam.ui.theme.scrimDark
import com.example.amsterdam.ui.theme.scrimDarkHighContrast
import com.example.amsterdam.ui.theme.scrimDarkMediumContrast
import com.example.amsterdam.ui.theme.scrimLight
import com.example.amsterdam.ui.theme.scrimLightHighContrast
import com.example.amsterdam.ui.theme.scrimLightMediumContrast
import com.example.amsterdam.ui.theme.secondaryContainerDark
import com.example.amsterdam.ui.theme.secondaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.secondaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.secondaryContainerLight
import com.example.amsterdam.ui.theme.secondaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.secondaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.secondaryDark
import com.example.amsterdam.ui.theme.secondaryDarkHighContrast
import com.example.amsterdam.ui.theme.secondaryDarkMediumContrast
import com.example.amsterdam.ui.theme.secondaryLight
import com.example.amsterdam.ui.theme.secondaryLightHighContrast
import com.example.amsterdam.ui.theme.secondaryLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceBrightDark
import com.example.amsterdam.ui.theme.surfaceBrightDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceBrightDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceBrightLight
import com.example.amsterdam.ui.theme.surfaceBrightLightHighContrast
import com.example.amsterdam.ui.theme.surfaceBrightLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerDark
import com.example.amsterdam.ui.theme.surfaceContainerDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighDark
import com.example.amsterdam.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighLight
import com.example.amsterdam.ui.theme.surfaceContainerHighLightHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighestDark
import com.example.amsterdam.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighestLight
import com.example.amsterdam.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerLight
import com.example.amsterdam.ui.theme.surfaceContainerLightHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowDark
import com.example.amsterdam.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowLight
import com.example.amsterdam.ui.theme.surfaceContainerLowLightHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowestDark
import com.example.amsterdam.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowestLight
import com.example.amsterdam.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.amsterdam.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceDark
import com.example.amsterdam.ui.theme.surfaceDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceDimDark
import com.example.amsterdam.ui.theme.surfaceDimDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceDimDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceDimLight
import com.example.amsterdam.ui.theme.surfaceDimLightHighContrast
import com.example.amsterdam.ui.theme.surfaceDimLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceLight
import com.example.amsterdam.ui.theme.surfaceLightHighContrast
import com.example.amsterdam.ui.theme.surfaceLightMediumContrast
import com.example.amsterdam.ui.theme.surfaceVariantDark
import com.example.amsterdam.ui.theme.surfaceVariantDarkHighContrast
import com.example.amsterdam.ui.theme.surfaceVariantDarkMediumContrast
import com.example.amsterdam.ui.theme.surfaceVariantLight
import com.example.amsterdam.ui.theme.surfaceVariantLightHighContrast
import com.example.amsterdam.ui.theme.surfaceVariantLightMediumContrast
import com.example.amsterdam.ui.theme.tertiaryContainerDark
import com.example.amsterdam.ui.theme.tertiaryContainerDarkHighContrast
import com.example.amsterdam.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.amsterdam.ui.theme.tertiaryContainerLight
import com.example.amsterdam.ui.theme.tertiaryContainerLightHighContrast
import com.example.amsterdam.ui.theme.tertiaryContainerLightMediumContrast
import com.example.amsterdam.ui.theme.tertiaryDark
import com.example.amsterdam.ui.theme.tertiaryDarkHighContrast
import com.example.amsterdam.ui.theme.tertiaryDarkMediumContrast
import com.example.amsterdam.ui.theme.tertiaryLight
import com.example.amsterdam.ui.theme.tertiaryLightHighContrast
import com.example.amsterdam.ui.theme.tertiaryLightMediumContrast
import com.example.ui.theme.Typography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AmsterdamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

