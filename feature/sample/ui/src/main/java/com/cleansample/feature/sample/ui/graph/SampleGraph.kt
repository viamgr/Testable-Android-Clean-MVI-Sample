package com.cleansample.feature.sample.ui.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.detail.SampleDetailScreen
import com.cleansample.ui_common.navigation.ArgumentScreen
import com.cleansample.ui_common.navigation.Graph
import com.cleansample.ui_common.navigation.composable

object SampleGraph : Graph {
    override val route: String = "samples"
    override val startDestination = DetailScreen.route

    object DetailScreen : ArgumentScreen(
        route = "detail/{id}",
        graph = SampleGraph,
        navArguments = listOf(
            navArgument("sampleId") {
                type = NavType.LongType
                defaultValue = 1500L
            }
        )
    ) {
        fun createRoute(id: Long) = "detail/$id"
        override fun getLabelResourceId(): Int = R.string.title_sample_detail
    }

}

fun NavGraphBuilder.addSamplesGraph(
    navigateToBrowserIntentCallback: (String) -> Unit,
    navigateToShareIntentCallback: (String) -> Unit,
    navigateToImageViewerCallback: (String) -> Unit,
    navigateGoogleMapsDirectionIntent: (String, String) -> Unit,
) {

    navigation(
        route = SampleGraph.route,
        startDestination = SampleGraph.startDestination,
    ) {
        composable(
            screen = SampleGraph.DetailScreen
        ) {
            SampleDetailScreen(
                navigateToBrowserIntentCallback = navigateToBrowserIntentCallback,
                navigateToShareIntentCallback = navigateToShareIntentCallback,
                navigateToImageViewerCallback = navigateToImageViewerCallback,
                navigateGoogleMapsDirectionIntent = navigateGoogleMapsDirectionIntent
            )
        }
    }
}
