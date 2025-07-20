plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.usercheckapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.usercheckapp"
        minSdk = 21
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true // Sudah benar, ViewBinding diaktifkan
    }
}

dependencies {
    // Retrofit untuk komunikasi API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp untuk menangani request dan interceptors
    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    // Picasso untuk memuat gambar
    implementation("com.squareup.picasso:picasso:2.71828")

    // RecyclerView untuk menampilkan data pengguna
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // SwipeRefreshLayout untuk implementasi pull-to-refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // ConstraintLayout untuk tata letak fleksibel
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // AppCompat untuk kompatibilitas dengan versi Android yang lebih lama
    implementation("androidx.appcompat:appcompat:1.3.1")

    // Core KTX untuk dukungan Kotlin yang lebih baik
    implementation("androidx.core:core-ktx:1.6.0")

    // Lifecycle untuk mempermudah penanganan siklus hidup
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Dependensi lainnya
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Test dan pengujian
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
