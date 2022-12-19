plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.safeargs)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        vectorDrawables {
            useSupportLibrary = true
        }
        testInstrumentationRunner = TestEnvironment.testInstrumentationRunner
    }

    testBuildType = TestEnvironment.testBuildType

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        create(testBuildType) {
            initWith(getByName("debug"))
        }
    }

    compileOptions {
        sourceCompatibility = ConfigData.jvmTarget
        targetCompatibility = ConfigData.jvmTarget
    }

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget.toString()
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
    implementation(project(BuildModules.BaseUi.COMMON_UI))
    implementation(project(BuildModules.BaseUi.THEME_UI))
    implementation(project(BuildModules.Feature.Sample.PRESENTATION))
    stagingImplementation(project(BuildModules.BaseUi.ANDROID_TEST_SHARED))

    addDependencies(FeatureUiDependencies.getDependencies())
}
