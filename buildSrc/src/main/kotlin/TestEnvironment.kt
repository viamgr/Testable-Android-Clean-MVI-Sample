import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object TestEnvironment {
    const val testInstrumentationRunner = "com.cleansample.android_test_shared.CustomTestRunner"
    const val testBuildType = "staging"
}


fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.stagingImplementation(dependencyNotation: Any) =
    add("stagingImplementation", dependencyNotation)