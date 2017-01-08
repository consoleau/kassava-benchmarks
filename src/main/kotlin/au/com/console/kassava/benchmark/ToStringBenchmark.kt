package au.com.console.kassava.benchmark

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

/**
 * toString() implementation benchmark.
 *
 * @author James Bassett (james.bassett@console.com.au)
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class ToStringBenchmark {

    lateinit var person: Person

    @Setup
    fun setup(){
        person = Person(firstName = "Joe", lastName = "Satriani", age = 60, employed = true)
    }

    @Benchmark fun manualToString(): String {
        return person.toString()
    }

    @Benchmark fun manualObjectsToString(): String {
        return person.objectsToString()
    }

    @Benchmark fun apacheToString(): String {
        return person.apacheToString()
    }

    @Benchmark fun apacheReflectionToString(): String {
        return person.apacheReflectionToString()
    }

    @Benchmark fun guavaToString(): String {
        return person.guavaToString()
    }

    @Benchmark fun kassavaToString(): String {
        return person.kassavaToString()
    }

    @Benchmark fun kassavaToStringWithArrayCreation(): String {
        return person.kassavaToStringWithArrayCreation()
    }

}