data class Dependency(
    val dependency: String,
    val dependencyVersion: String,
    val dependencyType: DependencyType,
    val excludes: List<Exclude> = listOf(),
)

data class Platform(
    val platform: String,
    val platformVersion: String,
    val dependencies: List<String>,
) {
    override fun toString(): String {
        return "${platform}:${platformVersion}"
    }
}

data class Exclude(
    val group: String,
    val module: String? = null,
)
