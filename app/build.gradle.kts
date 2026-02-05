plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.androidarchpattern_lab1"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.androidarchpattern_lab1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    implementation(libs.firebase.inappmessaging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    // Room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)


    //RXJava
    implementation("io.reactivex.rxjava3:rxjava:3.1.10")
    //RXJava with android to be lifecycle aware
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")

    //retrofit with RXJava
    implementation("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    //room with RXJava
    implementation("androidx.room:room-rxjava3:2.6.1")
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
