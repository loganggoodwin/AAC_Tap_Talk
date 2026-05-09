plugins {
    id("com.android.application")
}

android {
    namespace = "com.logangoodwin.aactaptalk"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.logangoodwin.aactaptalk"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
