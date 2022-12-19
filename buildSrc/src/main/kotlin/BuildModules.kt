object BuildModules {
    object AndroidApi {
        object Location {
            const val CONTRACT = ":api-android:location:contract"
            const val GOOGLE = ":api-android:location:google"
        }
    }

    object Base {
        const val CORE = ":base:core"
        const val ORBIT_UTILS = ":base:orbit-utils"
        const val TEST_SHARED = ":base:test-shared"
    }

    object BaseUi {
        const val COMMON_UI = ":base-ui:ui-common"
        const val THEME_UI = ":base-ui:ui-theme"
        const val ANDROID_TEST_SHARED = ":base-ui:android-test-shared"
    }

    object Data {
        const val REPOSITORY = ":data:repository"
        const val CONTRACT = ":data:contract"
    }

    object Datasource {
        const val REMOTE = ":datasource:remote"
    }

    object Domain {
        const val CONTRACT = ":domain:contract"
        const val USE_CASE = ":domain:use-case"
    }

    object Feature {
        object Sample {
            const val PRESENTATION = ":feature:sample:presentation"
            const val UI = ":feature:sample:ui"
        }
    }

}
