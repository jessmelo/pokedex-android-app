package com.jessmelo.apps.pokedex.ui.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.jessmelo.apps.pokedex.R

@OptIn(ExperimentalTextApi::class)
val GoogleFontsProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val Righteous = FontFamily(Font(
    googleFont = GoogleFont("Righteous"),
    fontProvider = GoogleFontsProvider)
)
