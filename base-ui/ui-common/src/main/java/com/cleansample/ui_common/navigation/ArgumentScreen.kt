package com.cleansample.ui_common.navigation

import androidx.navigation.NamedNavArgument

abstract class ArgumentScreen(
    override val route: String,
    override val graph: Graph,
    override var navArguments: List<NamedNavArgument> = emptyList(),
) : Screen, WithLabel
