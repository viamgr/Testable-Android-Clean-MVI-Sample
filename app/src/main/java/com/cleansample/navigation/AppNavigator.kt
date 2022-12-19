package com.cleansample.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.cleansample.feature.sample.ui.graph.SampleGraph
import com.cleansample.feature.sample.ui.graph.addSamplesGraph
import com.cleansample.ui_common.utils.openBrowserIntent
import com.cleansample.ui_common.utils.openGoogleMapsDirectionIntent
import com.cleansample.ui_common.utils.openShareIntent

@Composable
fun AppNavigator(
    navController: NavHostController = rememberNavController(),
) {
    Surface(Modifier.fillMaxSize()) {

        val context = LocalContext.current

        NavHost(
            navController = navController,
            startDestination = SampleGraph.route,
        ) {
            addSamplesGraph(
                navigateToImageViewerCallback = {

                },
                navigateToShareIntentCallback = context::openShareIntent,
                navigateToBrowserIntentCallback = context::openBrowserIntent,
                navigateGoogleMapsDirectionIntent = context::openGoogleMapsDirectionIntent)
        }
    }

}
