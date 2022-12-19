import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
}


android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
    }

    testBuildType = TestEnvironment.testBuildType
    buildTypes {
        val gradleLocalProperties = gradleLocalProperties(rootDir)

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
    implementation(project(BuildModules.AndroidApi.Location.CONTRACT))

    addDependencies(ApiModuleDependencies.getDependencies())

}
