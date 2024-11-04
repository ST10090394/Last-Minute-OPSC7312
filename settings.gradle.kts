import org.gradle.authentication.http.BasicAuthentication

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            authentication {
                create<BasicAuthentication>("basic")
            }
            credentials {
                username = "mapbox"
                password = "pk.eyJ1Ijoic3QxMDA5MDM5NCIsImEiOiJjbTFucjR6aWIweGVqMmpzZ3MzNHQ5N3g1In0.bfnw8J5MalbdRg2FnYKnvA"
            }
        }
    }
}

rootProject.name = "CarSpotterOPSC7312"
include(":app")

