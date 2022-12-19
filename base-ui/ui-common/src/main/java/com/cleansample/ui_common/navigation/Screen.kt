package com.cleansample.ui_common.navigation

import androidx.navigation.NamedNavArgument

interface Screen {
    val graph: Graph
    val route: String
    var navArguments: List<NamedNavArgument>

    val absoluteRoute: String
        get() = "${graph.route}/$route"
}