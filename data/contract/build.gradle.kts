plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
}


android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion


        vectorDrawables {
            useSupportLibrary = true
        }
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
}

dependencies {
    implementation(project(BuildModules.Base.CORE))
}
