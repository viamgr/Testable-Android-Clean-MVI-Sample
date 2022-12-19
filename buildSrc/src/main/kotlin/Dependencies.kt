interface Dependencies {
    fun getDependencies(): List<Dependency>
}

internal object AllDependencies {
    val espresso = Dependency(
        dependency = "androidx.test.espresso:espresso-core",
        dependencyVersion = DependencyVersions.espresso,
        dependencyType = DependencyType.API,
    )

    val appcompat = Dependency(
        dependency = "androidx.appcompat:appcompat",
        dependencyVersion = DependencyVersions.appcompatVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val activityCompose = Dependency(
        dependency = "androidx.activity:activity-compose",
        dependencyVersion = DependencyVersions.activityComposeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val materialTheme = Dependency(
        dependency = "androidx.compose.material3:material3",
        dependencyVersion = DependencyVersions.materialVersion,
        dependencyType = DependencyType.API
    )
    val constraintLayout = Dependency(
        dependency = "androidx.constraintlayout:constraintlayout-compose",
        dependencyVersion = DependencyVersions.constraintLayoutVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val coroutinesAndroid = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-android",
        dependencyVersion = DependencyVersions.coroutinesAndroidVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val coroutinesCore = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-core",
        dependencyVersion = DependencyVersions.coroutinesCoreVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val hiltAndroid = Dependency(
        dependency = "com.google.dagger:hilt-android",
        dependencyVersion = DependencyVersions.hiltVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val coil = Dependency(
        dependency = "io.coil-kt:coil-compose",
        dependencyVersion = DependencyVersions.coilVersion,
        dependencyType = DependencyType.API
    )

    val kotlinxSerializationJson = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-serialization-json",
        dependencyVersion = DependencyVersions.serializationJsonVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val mockkAndroidApi = Dependency(
        dependency = "io.mockk:mockk-android",
        dependencyVersion = DependencyVersions.mockkVersion,
        dependencyType = DependencyType.API
    )
    val mockkApi = Dependency(
        dependency = "io.mockk:mockk",
        dependencyVersion = DependencyVersions.mockkVersion,
        dependencyType = DependencyType.API
    )

    val mockkAgentApi = Dependency(
        dependency = "io.mockk:mockk-agent-jvm",
        dependencyVersion = DependencyVersions.mockkVersion,
        dependencyType = DependencyType.API
    )

    val coroutineTestApi = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-test",
        dependencyVersion = DependencyVersions.coroutinesAndroidVersion,
        dependencyType = DependencyType.API
    )

    val kotestApi = Dependency(
        dependency = "io.kotest:kotest-runner-junit5-jvm",
        dependencyVersion = DependencyVersions.kotestJUnit,
        dependencyType = DependencyType.API
    )

    val kotlinReflectApi = Dependency(
        dependency = "org.jetbrains.kotlin:kotlin-reflect",
        dependencyVersion = DependencyVersions.kotlinVersion,
        dependencyType = DependencyType.API
    )

    val turbineApi = Dependency(
        dependency = "app.cash.turbine:turbine",
        dependencyVersion = DependencyVersions.turbine,
        dependencyType = DependencyType.API
    )

    val kotestAssertions = Dependency(
        dependency = "io.kotest:kotest-assertions-core-jvm",
        dependencyVersion = DependencyVersions.kotestJUnit,
        dependencyType = DependencyType.API
    )

    val hiltCompiler = Dependency(
        dependency = "com.google.dagger:hilt-android-compiler",
        dependencyVersion = DependencyVersions.hiltAndroidCompilerVersion,
        dependencyType = DependencyType.KAPT
    )

    val hiltCompilerAndroidTest = Dependency(
        dependency = "com.google.dagger:hilt-android-compiler",
        dependencyVersion = DependencyVersions.hiltAndroidCompilerVersion,
        dependencyType = DependencyType.KAPT_ANDROID_TEST
    )

    val hiltAndroidTestingApi = Dependency(
        dependency = "com.google.dagger:hilt-android-testing",
        dependencyVersion = DependencyVersions.hiltAndroidCompilerVersion,
        dependencyType = DependencyType.API
    )

    val viewModel = Dependency(
        dependency = "androidx.lifecycle:lifecycle-viewmodel-ktx",
        dependencyVersion = DependencyVersions.lifecycleVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val lifecycleRuntime = Dependency(
        dependency = "androidx.lifecycle:lifecycle-runtime-ktx",
        dependencyVersion = DependencyVersions.lifecycleVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val composeUi = Dependency(
        dependency = "androidx.compose.ui:ui",
        dependencyVersion = DependencyVersions.composeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val materialComponents = Dependency(
        dependency = "com.google.android.material:material",
        dependencyVersion = DependencyVersions.materialComponentsVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val accompanistPager = Dependency(
        dependency = "com.google.accompanist:accompanist-pager",
        dependencyVersion = DependencyVersions.accompanistPager,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val composeFoundation = Dependency(
        dependency = "androidx.compose.foundation:foundation",
        dependencyVersion = DependencyVersions.composeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val navigationCompose = Dependency(
        dependency = "androidx.navigation:navigation-compose",
        dependencyVersion = DependencyVersions.navVersion,
        dependencyType = DependencyType.API
    )

    val daggerHiltNavigation = Dependency(
        dependency = "androidx.hilt:hilt-navigation-compose",
        dependencyVersion = DependencyVersions.hiltComposeNavigationVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val composeFoundationLayout = Dependency(
        dependency = "androidx.compose.foundation:foundation-layout",
        dependencyVersion = DependencyVersions.composeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val retrofit = Dependency(
        dependency = "com.squareup.retrofit2:retrofit",
        dependencyVersion = DependencyVersions.retrofitVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val okhttp3 = Dependency(
        dependency = "com.squareup.okhttp3:okhttp",
        dependencyVersion = DependencyVersions.okHttpVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val okhttpLoggingInterceptor = Dependency(
        dependency = "com.squareup.okhttp3:logging-interceptor",
        dependencyVersion = DependencyVersions.okHttpVersion,
        dependencyType = DependencyType.DEBUG_IMPLEMENTATION
    )

    val retrofitSerialization = Dependency(
        dependency = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter",
        dependencyVersion = DependencyVersions.retrofitSerialization,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    val orbitApi = Dependency(
        dependency = "org.orbit-mvi:orbit-viewmodel",
        dependencyVersion = DependencyVersions.orbitVersion,
        dependencyType = DependencyType.API
    )
    val orbitCompose = Dependency(
        dependency = "org.orbit-mvi:orbit-compose",
        dependencyVersion = DependencyVersions.orbitVersion,
        dependencyType = DependencyType.API,
        excludes = listOf(Exclude("org.jetbrains.kotlin"), Exclude("org.jetbrains.kotlinx"))
    )


    val orbitTestImpl = Dependency(
        dependency = "org.orbit-mvi:orbit-test",
        dependencyVersion = DependencyVersions.orbitVersion,
        dependencyType = DependencyType.TEST_IMPL,
        excludes = listOf(Exclude("org.jetbrains.kotlin"), Exclude("org.jetbrains.kotlinx"))
    )

    val timber = Dependency(
        dependency = "com.jakewharton.timber:timber",
        dependencyVersion = DependencyVersions.timberVersion,
        dependencyType = DependencyType.API
    )

    val testRunnerImpl = Dependency(
        dependency = "androidx.test:runner",
        dependencyVersion = DependencyVersions.androidXTestVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val junitApi = Dependency(
        dependency = "org.junit.jupiter:junit-jupiter-api",
        dependencyVersion = DependencyVersions.junitVersion,
        dependencyType = DependencyType.API
    )

    val kotlinTest = Dependency(
        dependency = "org.jetbrains.kotlin:kotlin-test-junit5",
        dependencyVersion = DependencyVersions.kotlinVersion,
        dependencyType = DependencyType.API
    )

    val testRules = Dependency(
        dependency = "androidx.test:rules",
        dependencyVersion = DependencyVersions.androidXTestVersion,
        dependencyType = DependencyType.API
    )

    val androidXJunitImpl = Dependency(
        dependency = "androidx.test.ext:junit",
        dependencyVersion = DependencyVersions.androidXJunit,
        dependencyType = DependencyType.API
    )
}


