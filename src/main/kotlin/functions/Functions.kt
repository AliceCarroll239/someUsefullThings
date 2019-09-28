package functions

import classes.ClassForReflection
import org.testng.Assert
import kotlin.reflect.full.declaredMemberProperties

class Functions {

    fun infixFuncAndRegex() {
        infix fun String.substringMatches(r: Regex): List<String> {
            return r.findAll(this)
                .map { it.value }
                .toList()
        }

        val matches = "a bc def" substringMatches ".*? ".toRegex()
        Assert.assertEquals(listOf("a ", "bc "), matches)
    }

    fun typeExtendsFuncAndUnitParameters() {
        fun <T> ArrayList<T>.conditionFilter(condition: (T) -> Boolean): ArrayList<T> {
            val result = arrayListOf<T>()
            for (item in this) {
                if (condition(item)) {
                    result.add(item)
                }
            }
            return result
        }

        var list = arrayListOf<Int>()
        for (number in 1..10) {
            list.add(number)
        }

        list.filter { it % 2 == 0 }.forEach {
            print(it.toString())
        }
    }

    fun printParamsReflection() {
        val customObject = ClassForReflection()
        customObject.javaClass.kotlin.declaredMemberProperties.forEach {
            println("Param ${it.name}  of type ${it.returnType} with value ${it.get(customObject)}")
        }
    }
}