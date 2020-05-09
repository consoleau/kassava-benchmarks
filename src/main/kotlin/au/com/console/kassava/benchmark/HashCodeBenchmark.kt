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
open class HashCodeBenchmark {

    lateinit var person: Person

    @Setup
    fun setup(){
        person = Person(firstName = "Joe", lastName = "Satriani", age = 60, employed = true)
    }

    @Benchmark fun manualHashCode(): Int {
        return person.hashCode()
    }

    @Benchmark fun manualObjectsHashCode(): Int {
        return person.objectsHashCode()
    }

    @Benchmark fun apacheHashCode(): Int {
        return person.apacheHashCode()
    }

    @Benchmark fun apacheReflectionHashCode(): Int {
        return person.apacheReflectionHashCode()
    }

    @Benchmark fun guavaHashCode(): Int {
        return person.guavaHashCode()
    }

    @Benchmark fun kassavaHashCode(): Int {
        return person.kassavaHashCode()
    }

    @Benchmark fun kassavaHashCodeWithArrayCreation(): Int {
        return person.kassavaHashCodeWithArrayCreation()
    }

}
