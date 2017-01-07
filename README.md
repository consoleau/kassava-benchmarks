Kassava Benchmarks
==========
[![Build Status](https://travis-ci.org/consoleau/kassava-benchmarks.svg?branch=master)](https://travis-ci.org/consoleau/kassava-benchmarks)

Benchmarks Kassava's `equals()` and `toString()` implementations against manual, Guava and Apache implementations.

Special thanks to JetBrains for the Kotlin/JMH example (on which this project is based) at https://github.com/JetBrains/kotlin-benchmarks

Build:
```
mvn clean package
```

Run:
10 warm up rounds, 5 iterations, 1 fork, avg time in ns
```
java -jar target/benchmarks.jar -wi 10 -i 5 -f 1 -tu ns -bm avgt
```