package com.jessmelo.apps.pokedex.ui.util

import java.util.*

fun generateRandomPokemonId(): String {
    return (1..1008).random().toString()
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") {
    it.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
    }
}

fun hgToKg(weight: Int): String {
    val kg: Double = weight * 0.1
    return String.format("%.2f", kg)
}

fun dcTocm(height: Int): String {
    return (height*10).toString()
}
