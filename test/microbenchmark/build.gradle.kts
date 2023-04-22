plugins {
	id("com.android.library")
	id("androidx.benchmark")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
}

android {
	namespace = "com.example.poc.microbenchmark"

	defaultConfig {
		testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
		testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR,LOW-BATTERY,UNLOCKED"
		testInstrumentationRunnerArguments["androi'x.benchmark.profiling.mode"] = "None"


		// See https://stackoverflow.com/a/513259/2067157
		// Print garbage collection and compilation to check if it's interfering in the benchmarking
		testInstrumentationRunnerArguments["-verbose:gc"]
		testInstrumentationRunnerArguments["-XX:+PrintCompilation"]

		// Use EpsilonGC to prevent the GC to be called during measured loop
		testInstrumentationRunnerArguments["-XX:+UseEpsilonGC"]

		// Set JAVA heap initial and maximum to a high value so GC does not need to be called
		testInstrumentationRunnerArguments["-Xms4096m"]
		testInstrumentationRunnerArguments["-Xmx4096m"]
	}

	testBuildType = "release"

	buildTypes {
		debug {
			// Since isDebuggable can't be modified by gradle for library modules,
			// it must be done in a manifest - see src/androidTest/AndroidManifest.xml
			isMinifyEnabled = true
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"benchmark-proguard-rules.pro"
			)
		}
		release {
			isDefault = true
		}
	}

	packagingOptions {
		resources {
			resources.excludes.add("META-INF/*")
		}
	}
}

dependencies {
	androidTestImplementation("androidx.test:runner:1.4.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.annotation:annotation:1.1.0")
	androidTestImplementation("androidx.benchmark:benchmark-junit4:1.2.0-alpha01")
    androidTestImplementation(project(":feature:settings"))
    // Add your dependencies here. Note that you cannot benchmark code
	// in an app module this way - you will need to move any code you
	// want to benchmark to a library module:
	// https://developer.android.com/studio/projects/android-library#Convert
	// TODO not working with feature modules because of dex problem. Maybe catalog of dependencies
	// solves the problem.
}