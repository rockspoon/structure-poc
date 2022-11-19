# Benchmark

Benchmark involves the measure of performance of the application. It's advisable, as in tests, to create benchmarks for components know to have performance impact before the problem appears.

The same way the recommended workflow to solve bugs involves first create a class or function to reproduce the error and then make code alterations, the work flow to solve performance problems involves first to create benchmark classes to reproduce the performance problem and then make code alterations until the results of the benchmarks met the acceptable value (acceptance criteria).

For graphic stuttering problems, for example, the usual acceptance criteria is the graphics performance be 60fps or, in other terms, the whole graphic computation cycle takes less than 16ms to perform.

Benchmarks only makes sense on physical devices, even if it's possible to run it on emulators, but you can still use the emulator to develop and debug the benchmark classes.


## Microbenchmark

The microbenchmark classes are concentrated in a separate module because the microbenchmark needs for accuracy that the debug be false.

To work with the microbenchmark, make sure first that its module build variant is set to "release", both in the IDE and in the Gradle file. Once done, the benchmark classes and the arrow to start the tests will appear.

## Macrobenchmark

Before running the tests you need to install the application using the run or debug ":app", otherwise the benchmark will not find the application launcher.

## Debugging

A lot of problems of benchmarking will not be logged in the run or debug console, it will just cancel the tests and show a grey symbol. But the error are still logged in the LogCat.

## Road map

It's intended that after refactoring of the project structure [include JIRA epic here] and implementation of unit and instrumented tests [include epic maybe], benchmarks be implemented in multiple components of the application ([include JIRA tasks here])