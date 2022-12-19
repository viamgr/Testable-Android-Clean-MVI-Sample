plugins {
    id(BuildPlugins.Apply.androidApplication)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}

android {

    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.appID
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
        testInstrumentationRunner = TestEnvironment.testInstrumentationRunner
    }

    commonBuildTypes(TestEnvironment.testBuildType)

    compileOptions {
        sourceCompatibility = ConfigData.jvmTarget
        targetCompatibility = ConfigData.jvmTarget
    }

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget.toString()

        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependencyVersions.composeVersion
    }
}


dependencies {
    implementation(project(BuildModules.Base.CORE))
    testImplementation(project(BuildModules.Base.TEST_SHARED))

    implementation(project(BuildModules.BaseUi.COMMON_UI))
    implementation(project(BuildModules.BaseUi.THEME_UI))
    implementation(project(BuildModules.Feature.Sample.UI))

    implementation(project(BuildModules.AndroidApi.Location.CONTRACT))
    implementation(project(BuildModules.AndroidApi.Location.GOOGLE))

    implementation(project(BuildModules.Data.REPOSITORY))
    implementation(project(BuildModules.Datasource.REMOTE))

    androidTestImplementation(project(BuildModules.BaseUi.ANDROID_TEST_SHARED))

    addDependencies(AppModuleDependencies.getDependencies())

}