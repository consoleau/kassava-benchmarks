package au.com.console.kassava.benchmark

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

/**
 * equals() implementation benchmark.
 *
 * @author James Bassett (james.bassett@console.com.au)
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class EqualsBenchmark {

    lateinit var person1 : Person
    lateinit var person2 : Person

    @Setup
    fun setup(){
        fun person() = Person(firstName = "Joe", lastName = "Satriani", age = 60, employed = true)
        person1 = person()
        person2 = person()
    }

    @Benchmark fun manualEquals(): Boolean {
        return person1.manualEquals(person2)
    }

    @Benchmark fun apacheEquals(): Boolean {
        return person1.apacheEquals(person2)
    }

    @Benchmark fun apacheReflectionEquals(): Boolean {
        return person1.apacheReflectionEquals(person2)
    }

    // no guava equals!

    @Benchmark fun kassavaEquals(): Boolean {
        return person1.kassavaEquals(person2)
    }

    @Benchmark fun kassavaEqualsWithArrayCreation(): Boolean {
        return person1.kassavaEqualsWithArrayCreation(person2)
    }

}