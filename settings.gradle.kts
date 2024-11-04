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
                password = "pk.eyJ1Ijoic3QxMDA5MDM5NCIsImEiOiJjbTMyemh1Z2cxaTR0Mm5zYzM0em4xZWFoIn0.LahtMzGsj60U7BKoAP9m2w"
            }
        }
    }
}

rootProject.name = "CarSpotterOPSC7312"
include(":app")

