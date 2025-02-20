package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.amsterdam.R

val AmsterdamFont = FontFamily(
    Font(R.font.amsterdam, FontWeight.Normal)
)

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val PoppinsFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Poppins"),
        fontProvider = provider,
    )
)
val baseline = Typography()


val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
//    titleSmall = baseline.titleSmall.copy(fontFamily = PoppinsFontFamily),
    titleSmall = TextStyle(
        fontFamily = AmsterdamFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = PoppinsFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = PoppinsFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = PoppinsFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = PoppinsFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = PoppinsFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = PoppinsFontFamily)
//    bodyLarge = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//
//    bodyMedium = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp
//    ),
//    bodySmall = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = AmsterdamFont,
//        fontWeight = FontWeight.Normal,
//        fontSize = 11.sp
//    )
)
