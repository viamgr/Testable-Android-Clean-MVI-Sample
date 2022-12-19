plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.safeargs)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
    generateStubs = true
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
    }

    commonBuildTypes(TestEnvironment.testBuildType)
    compileOptions {
        sourceCompatibility = ConfigData.jvmTarget
        targetCompatibility = ConfigData.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependencyVersions.composeVersion
    }

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget.toString()

    }

}

dependencies {
    implementation(project(BuildModules.Base.CORE))
    implementation(project(BuildModules.BaseUi.THEME_UI))
    addDependencies(UiCommonModuleDependencies.getDependencies())
}
