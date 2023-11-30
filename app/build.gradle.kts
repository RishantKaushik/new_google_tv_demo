plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.github.ConnectSDK:Connect-SDK-Android:2.0.0")
    implementation ("com.google.protobuf:protobuf-java:3.19.3") // Replace with the version you need
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    //implementation ("org.bouncycastle:bcprov-jdk15on:1.68")
   // implementation ("org.bouncycastle:bcpkix-jdk15on:1.68")
    implementation ("org.bouncycastle:bcpkix-jdk15on:1.68")
    implementation ("org.bouncycastle:bcprov-jdk15on:1.68")


    implementation(files("libs\\anymote.jar"))
    implementation(files("libs\\polo.jar"))
 //   implementation(files("libs\\protobuf-java-2.2.0-lite.jar"))
  //  implementation(files("libs\\bcprov-jdk15-143.jar"))
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}