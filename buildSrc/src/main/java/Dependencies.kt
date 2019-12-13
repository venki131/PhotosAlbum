import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 23
    const val compileSdk = 28
    const val targetSdk = 28
    val javaVersion = JavaVersion.VERSION_1_8
    const val buildTools = "28.0.3"
}

object Versions {
    // <editor-fold desc="google">
    const val androidx_core = "1.0.1"
    const val androidx_recyclerview = "1.0.0"
    const val androidx_navigation = "2.0.0"
    const val androidx_constraintLayout = "1.1.3"
    const val material = "1.1.0-alpha04"
    const val glide = "4.10.0"
    const val life_cycle = "2.1.0"
    // </editor-fold>

    // <editor-fold desc="testing">
    const val junit = "4.12"
    const val androidx_espresso = "3.1.0"
    const val androidx_testing = "1.1.1"
    //</editor-fold>

    // <editor-fold desc="tools">
    const val gradleandroid = "3.5.0"
    const val kotlin = "1.3.20"
    const val gradleversions = "0.21.0"
    // </editor-fold>

    const val dagger = "2.22"

    const val retrofit = "2.5.0"

    const val logging_interceptor = "4.2.1"

    const val rx = "2.1.1"
    const val rx_adapter = "2.5.0"
    const val reactive_streams = "1.1.1"

    const val legacy = "1.0.0"

}

object Deps {
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    val androidx_material = "com.google.android.material:material:${Versions.material}"
    val androidx_navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigation}"
    val androidx_navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigation}"
    val androidx_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerview}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_annotation_processor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val androidx_lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.life_cycle}"
    val androidx_lifeCycle_compiler = "android.arch.lifecycle:compiler:${Versions.life_cycle}"
    val legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    //Dagger
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_support_android = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_android_compiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //http logging
    val http_logging = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    //RxAndroid
    val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx}"

    //RxJava
    val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx}"

    // Rx-Retrofit Call Adapter
    val rx_call_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rx_adapter}"

    // Reactive Streams (convert Observable to LiveData)
    val react_stream = "android.arch.lifecycle:reactivestreams:${Versions.reactive_streams}"

    val testlib_junit = "junit:junit:${Versions.junit}"

    val testandroidx_rules = "androidx.test:rules:${Versions.androidx_testing}"
    val testandroidx_runner = "androidx.test:runner:${Versions.androidx_testing}"
    val testandroidx_espressocore = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.gradleandroid}"
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val tools_gradleversions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleversions}"

}

