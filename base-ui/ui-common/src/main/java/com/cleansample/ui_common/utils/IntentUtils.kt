package com.cleansample.ui_common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openBrowserIntent(uri: String): Boolean {
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse(uri)
    return try {
        startActivity(openURL)
        true
    } catch (e: Exception) {
        false
    }
}

fun Context.openShareIntent(data: String): Boolean {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, data)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    return try {
        startActivity(shareIntent)
        true
    } catch (e: Exception) {
        false
    }
}

fun Context.openGoogleMapsDirectionIntent(latitude: String, longitude: String): Boolean {
    val gmmIntentUri =
        Uri.parse("google.navigation:q=$latitude,$longitude")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")
    return try {
        startActivity(mapIntent)
        true
    } catch (e: Exception) {
        false
    }
}
