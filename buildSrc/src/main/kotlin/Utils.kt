import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware


val Project.android: TestedExtension
    get() =
        (this as ExtensionAware).extensions.getByName("android") as TestedExtension


fun Project.commonBuildTypes(
    runningTestBuildType: String, action: NamedDomainObjectContainer<BuildType>.() -> Unit = {},
) {
    android.apply {
        testBuildType = runningTestBuildType
        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
            }

            create(testBuildType) {
                initWith(getByName("debug"))
            }

            action(this)
        }
    }
}
