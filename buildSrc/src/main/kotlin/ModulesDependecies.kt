object AppModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.appcompat,
        AllDependencies.activityCompose,
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.hiltCompilerAndroidTest,
    )
}

object UiThemeModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.appcompat,
        AllDependencies.materialTheme,
        AllDependencies.materialComponents,
        AllDependencies.constraintLayout,
    )
}

object FeatureUiDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coroutinesCore,
        AllDependencies.coroutinesAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.daggerHiltNavigation,
        AllDependencies.hiltAndroid,
        AllDependencies.composeUi,
        AllDependencies.viewModel,
        AllDependencies.lifecycleRuntime,
        AllDependencies.hiltCompilerAndroidTest,
        AllDependencies.accompanistPager,
    )
}

object FeaturePresentationDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coroutinesCore,
        AllDependencies.orbitTestImpl,
        AllDependencies.coroutinesAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.hiltAndroid,
        AllDependencies.composeUi,
        AllDependencies.orbitApi,
        AllDependencies.viewModel,
    )
}

object CoreModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.timber,
        AllDependencies.hiltAndroid,
        AllDependencies.coroutinesAndroid,
        AllDependencies.coroutinesCore,
    )

}

object DataModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
    )

}

object DomainModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.coroutinesAndroid,
        AllDependencies.coroutinesCore,
    )
}

object UiCommonModuleDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.materialTheme,
        AllDependencies.coil,
        AllDependencies.viewModel,
        AllDependencies.navigationCompose,
        AllDependencies.orbitCompose,
        AllDependencies.composeFoundation,
        AllDependencies.composeFoundationLayout,
        AllDependencies.composeUi,
    )
}

object TestSharedModuleDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coroutinesCore,
        AllDependencies.junitApi,
        AllDependencies.mockkApi,
        AllDependencies.mockkAgentApi,
        AllDependencies.testRunnerImpl,
        AllDependencies.coroutineTestApi,
        AllDependencies.kotestApi,
        AllDependencies.kotlinReflectApi,
        AllDependencies.kotestAssertions,
        AllDependencies.turbineApi,
    )
}

object AndroidTestSharedModuleDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coroutinesAndroid,
        AllDependencies.coroutinesCore,
        AllDependencies.mockkAndroidApi,
        AllDependencies.hiltAndroid,
        AllDependencies.coroutineTestApi,
        AllDependencies.appcompat,
        AllDependencies.junitApi,
        AllDependencies.testRunnerImpl,
        AllDependencies.hiltCompiler,
        AllDependencies.testRules,
        AllDependencies.espresso,
        AllDependencies.androidXJunitImpl,
        AllDependencies.hiltAndroidTestingApi,
    )
}

object RemoteModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.retrofit,
        AllDependencies.okhttp3,
        AllDependencies.okhttpLoggingInterceptor,
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.kotlinxSerializationJson,
        AllDependencies.retrofitSerialization,
    )
}

object ApiModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
    )
}


object OrbitUtilsDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.viewModel,
        AllDependencies.coroutinesCore,
        AllDependencies.orbitApi,
    )
}
