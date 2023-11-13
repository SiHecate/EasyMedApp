plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.hastanerandevu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hastanerandevu"
        minSdk = 26
        targetSdk = 33
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
    implementation ("org.hibernate:hibernate-core:5.5.6.Final")
    implementation ("org.hibernate:hibernate-entitymanager:5.5.6.Final")
    implementation ("org.hibernate:hibernate-java8:5.5.6.Final")
    implementation("androidx.room:room-runtime:2.6.0")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    annotationProcessor("androidx.room:room-compiler:2.6.0")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}