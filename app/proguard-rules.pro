# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-printmapping mapping.txt

-keep class com.example.loginsqlite.DatabaseHelper {
    *;
}

# Keep all classes and methods in your application's namespace
-keep class com.example.loginsqlite.** { *; }

# Keep all public and protected methods in your application's namespace
-keepclassmembers class com.example.loginsqlite.** {
    public <methods>;
    protected <methods>;
}

# Keep all classes from AndroidX libraries
-keep class androidx.** { *; }

# Keep all classes from AndroidX Compose libraries
-keep class androidx.compose.** { *; }

# Keep all classes from Activity Compose
-keep class androidx.activity.compose.** { *; }

# Keep all classes from ConstraintLayout Compose
-keep class androidx.constraintlayout.compose.** { *; }

# Keep all classes from Android Gradle Plugin
-keep class com.android.build.api.** { *; }

# Keep all classes from Material Components for Android
-keep class com.google.android.material.** { *; }

# Keep all classes from Kotlin standard library
-keep class kotlin.** { *; }

# Keep all classes from Kotlin reflect
-keep class kotlin.reflect.** { *; }

# If you use any custom views or resources, add rules to keep them safe
# For example, to keep all custom views and resources safe:
-keep class com.example.loginsqlite.values.** { *; }
-keep class com.example.loginsqlite.drawable.** { *; }
-keep class com.example.loginsqlite.layouts.** { *; }