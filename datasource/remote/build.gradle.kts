plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.kotlinxSerialization)
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

    testBuildType = TestEnvironment.testBuildType
    commonBuildTypes(TestEnvironment.testBuildType) {

        sourceSets.getByName("release") {
            java.srcDir("src/releaseDebug/java")
        }
        sourceSets.getByName("debug") {
            java.srcDir("src/releaseDebug/java")
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

}

dependencies {
    testImplementation(project(BuildModules.Base.TEST_SHARED))


    implementation(project(BuildModules.Base.CORE))
    implementation(project(BuildModules.Data.CONTRACT))

    addDependencies(RemoteModuleDependencies.getDependencies())
}


