project.allprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}