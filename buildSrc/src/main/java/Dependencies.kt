object Version {
    const val KOTLIN = "1.3.72"
}

object ProjectConfig {
    const val GRADLE = "com.android.tools.build:gradle:4.0.0"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
    const val HILT_ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
}

object AndroidConfig {
    const val COMPILE_SDK = 29
    const val APP_ID = "com.example.beokweather"
    const val MIN_SDK = 23
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object Dependencies {
    private const val HILT_VER = "2.28-alpha"
    private const val LIFECYCLE_VER = "2.2.0"
    private const val HILT_JETPACK_VER = "1.0.0-alpha01"

    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Version.KOTLIN}"

    const val MATERIAL = "com.google.android.material:material:1.1.0"
    const val CORE_KTX = "androidx.core:core-ktx:1.3.0"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"

    const val HILT_ANDROID = "com.google.dagger:hilt-android:$HILT_VER"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VER"

    const val DAGGER_HILT_LIFECYCLE_VM = "androidx.hilt:hilt-lifecycle-viewmodel:$HILT_JETPACK_VER"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:$HILT_JETPACK_VER"

    const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"

    const val LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:$LIFECYCLE_VER"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VER"

    const val FRAGMENT_EXT = "androidx.fragment:fragment-ktx:1.2.5"
}

object TestDependencies {
    const val JUNIT = "junit:junit:4.12"
    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.1"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.2.0"
}

object NetworkDependencies {
    private const val RETROFIT_VER = "2.7.2"
    private const val MOSHI_VER = "1.9.2"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VER"

    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VER"
    const val MOSHI = "com.squareup.moshi:moshi:$MOSHI_VER"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VER"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VER"

    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:3.14.2"
}