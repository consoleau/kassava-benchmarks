package au.com.console.kassava.benchmark

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import com.google.common.base.MoreObjects
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.ToStringBuilder
import java.util.*

/**
 * Simple class for benchmarking Kassava equals()/toString() implementations
 * against manual, guava and apache implementations.
 *
 * @author James Bassett (james.bassett@console.com.au)
 */
class Person(val firstName: String, val lastName: String, val age: Int, val employed: Boolean) {

    companion object {
        private val properties = arrayOf(Person::firstName, Person::lastName, Person::age, Person::employed)
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other !is Person) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (age != other.age) return false
        if (employed != other.employed) return false
        return true
    }

    fun objectsEquals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false
        return Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(age, other.age) &&
                Objects.equals(employed, other.employed)
    }

    fun apacheEquals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false
        return EqualsBuilder()
                .append(firstName, other.firstName)
                .append(lastName, other.lastName)
                .append(age, other.age)
                .append(employed, other.employed)
                .build()
    }

    fun apacheReflectionEquals(other: Any?): Boolean {
        return EqualsBuilder.reflectionEquals(this, other)
    }

    fun kassavaEquals(other: Any?): Boolean {
        return kotlinEquals(other = other, properties = properties)
    }

    fun kassavaEqualsWithArrayCreation(other: Any?): Boolean {
        return kotlinEquals(
                other = other,
                properties = arrayOf(Person::firstName, Person::lastName, Person::age, Person::employed)
        )
    }

    override fun toString(): String{
        return "Person(firstName='$firstName', lastName='$lastName', age=$age, employed=$employed)"
    }

    fun objectsToString(): String {
        return "Person(firstName='${Objects.toString(firstName)}', lastName='${Objects.toString(lastName)}', age=${Objects.toString(age)}, employed=${Objects.toString(employed)})"
    }

    fun guavaToString(): String {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("age", age)
                .add("employed", employed)
                .toString()
    }

    fun apacheToString(): String {
        return ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .append("employed", employed)
                .build()
    }

    fun apacheReflectionToString(): String {
        return ToStringBuilder.reflectionToString(this)
    }

    fun kassavaToString(): String {
        return kotlinToString(properties = properties)
    }

    fun kassavaToStringWithArrayCreation(): String {
        return kotlinToString(
                properties = arrayOf(Person::firstName, Person::lastName, Person::age, Person::employed)
        )
    }

    override fun hashCode() = Objects.hash(firstName, lastName, age, employed)
}