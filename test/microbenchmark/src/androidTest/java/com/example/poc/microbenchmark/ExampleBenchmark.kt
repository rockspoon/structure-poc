package com.example.poc.microbenchmark

import android.util.Log
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleBenchmark {

	@get:Rule
	val benchmarkRule = BenchmarkRule()

	@Test
	fun log() {
		Log.d("ExampleBenchmark", "The benchmark loop will start.")
		benchmarkRule.measureRepeated {
			val x = 1 + 1
			// Measuring log does not work because it runs out of memory.
			//Log.d("LogBenchmark", "the cost of writing this log method will be measured")
		}
		Log.d("ExampleBenchmark", "The benchmark loop stopped.")
	}
}